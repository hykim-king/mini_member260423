/**
 * 파일명: MemberServiceImpl.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-27 <br>
 */
package com.pcwk.member.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.pcwk.cmn.DTO;
import com.pcwk.cmn.PLogger;
import com.pcwk.cmn.StringUtil;
import com.pcwk.member.dao.MemberDao;
import com.pcwk.member.domain.MemberVO;

/**
 * 
 */
public class MemberServiceImpl implements MemberService,PLogger {

	//Dao
	MemberDao  memberDao;
	
	/** 
	 * 
	 */
	public MemberServiceImpl() {
		memberDao = new MemberDao();
		
		 
	}



	
	@Override
	public int addMember(MemberVO param) {
		
		if(param == null) {
			return 0;//0:실패
		}
		//" pckw ", ""

		//회원ID,이름,비밀번호,이메일,가입일,권한
		if(StringUtil.isBlank(param.getMemberId()) 
				|| StringUtil.isBlank(param.getName())
				|| StringUtil.isBlank(param.getPassword())
				|| StringUtil.isBlank(param.getEmail())
				|| StringUtil.isBlank(param.getRole())) {
			return 0;
		}
		
		//가입일: 당일
		param.setRegDate(StringUtil.formatDate("yyyy/MM/dd"));

		
		
		return memberDao.doSave(param);
	}

	@Override
	public int updateMember(MemberVO param) {
        if(null == param) {
        	return 0;//
        }
		
		//회원ID,이름,비밀번호,이메일,가입일,권한
		if(StringUtil.isBlank(param.getMemberId()) 
				|| StringUtil.isBlank(param.getName())
				|| StringUtil.isBlank(param.getPassword())
				|| StringUtil.isBlank(param.getEmail())
				|| StringUtil.isBlank(param.getRegDate())
				|| StringUtil.isBlank(param.getRole())) {
			return 0;
		}
		
		
		
		return memberDao.doUpdate(param);
	}

	@Override
	public int deleteMember(String memberId) {

		
		if(StringUtil.isBlank(memberId)) {
			return 0;
		}
		
		MemberVO inVO=new MemberVO();
		inVO.setMemberId(memberId);
		
		
		return memberDao.doDelete(inVO);
	}

	@Override
	public MemberVO findMember(String memberId) {
		if(StringUtil.isBlank(memberId)) {
			return null;
		}
		
		MemberVO inVO=new MemberVO();
		inVO.setMemberId(memberId);
		return memberDao.doSelectOne(inVO);
		
	}

	@Override
	public List<MemberVO> findMembers(DTO param) {
		if(null == param) {
			param = new DTO();
			param.setSearchDiv("");//전체
			param.setSearchWord("");//검색어
		}
		
		return memberDao.doRetrieve(param);
	}

	@Override
	public int saverMembersToFile() {
		return memberDao.writeMemberData(MemberDao.MEMBER_DATA);
	}

}
