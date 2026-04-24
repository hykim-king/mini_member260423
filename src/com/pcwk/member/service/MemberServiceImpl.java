/**
 * 파일명: MemberServiceImpl.java  <br>
 * 설명:  회원정보 Service<br>
 * 작성자: user <br>
 * 작성일: 2026. 4. 24. <br>
 * 버전 : 1.0
 */
package com.pcwk.member.service;

import java.time.LocalDate;
import java.util.List;

import com.pcwk.cmn.DTO;
import com.pcwk.cmn.PLogger;
import com.pcwk.member.dao.MemberDao;
import com.pcwk.member.domain.MemberVO;

/**
 * 
 */
public class MemberServiceImpl implements MemberService,PLogger {

	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao=new MemberDao();
	}

	@Override
	public int addMember(MemberVO param) {
        if (param == null) {
            return 0;
        }

        if (isBlank(param.getMemberId()) 
        		|| isBlank(param.getName())
                || isBlank(param.getPassword()) 
                || isBlank(param.getEmail())
                || isBlank(param.getRole())) {
            return 0;
        }

        // 가입일 자동 설정
        if (isBlank(param.getRegDate())) {
            param.setRegDate(LocalDate.now().toString());
        }

        return memberDao.doSave(param);
	}

	@Override
	public int updateMember(MemberVO param) {
        if (param == null || isBlank(param.getMemberId())) {
            return 0;
        }

        return memberDao.doUpdate(param);
	}

	@Override
	public int deleteMember(String memberId) {
        if (isBlank(memberId)) {
            return 0;
        }

        MemberVO inVO = new MemberVO();
        inVO.setMemberId(memberId);

        return memberDao.doDelete(inVO);
	}

	@Override
	public MemberVO findMember(String memberId) {
        if (isBlank(memberId)) {
            return null;
        }

        MemberVO inVO = new MemberVO();
        inVO.setMemberId(memberId);

        return memberDao.doSelectOne(inVO);
	}

	@Override
	public List<MemberVO> findMembers(DTO search) {
        if (search == null) {
            search = new DTO();
            search.setSearchDiv("ALL");
            search.setSearchWord("");
        }

        return memberDao.doRetrieve(search);
	}

	@Override
	public int saveMembersToFile() {
        return memberDao.writeMemberData(MemberDao.MEMBER_DATA);
	}
	
    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
