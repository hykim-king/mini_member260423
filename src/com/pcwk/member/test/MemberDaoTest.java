/**
 * 파일명: MemberDaoTest.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-23 <br>
 */
package com.pcwk.member.test;

import java.util.List;

import com.pcwk.cmn.DTO;
import com.pcwk.member.dao.MemberDao;
import com.pcwk.member.domain.MemberVO;

/**
 * 
 */
public class MemberDaoTest {

	MemberDao dao; //회원 Dao
	MemberVO  member01; //회원 CRUD   
	DTO       dto; //검색
	
	public MemberDaoTest() {
		dao=new MemberDao();
		member01 = new MemberVO("pcwk06","이상무06","4321a","jamesol@param.com","2026/04/24","일반");
		//검색
		dto=new DTO();
		
		
	}
	
	public void getMemberDataRead() {
		//System.out.println("dao: "+dao);
		//int memberCount=dao.getMemberDataRead(MemberDao.MEMBER_DATA);
		//System.out.println("memberCount:"+memberCount);
	}
	
	public void writeMemberData() {
		int memberCount= dao.writeMemberData(MemberDao.MEMBER_DATA);
		System.out.println("memberCount:"+memberCount);
	}
	
	public void doSave() {
		int flag = dao.doSave(member01);
		
		System.out.println("doSave flag: "+flag);
	}
	
	
	public void doDelete() {
		int flag = dao.doDelete(member01);
		System.out.println("doDelete flag: "+flag);
	}
	
	public void doSelectOne() {
		MemberVO vo = dao.doSelectOne(member01);
		
		System.out.println("doSelectOne: "+vo);
	}
	
	public void doUpdate() {
		//수정: ID는 수정불가 
		member01 = new MemberVO("pcwk06","이상무06_U","4321a_U","jamesol_U@param.com","2026/04/30","관리자");
		int flag=dao.doUpdate(member01);
		
		System.out.println("doUpdate: "+flag);
	}
	
	public void doRetrieve() {
		//전체 조회
		dto.setSearchDiv("");
		
		List<MemberVO> dataList =dao.doRetrieve(dto);
		
		for(MemberVO vo :dataList) {
			System.out.println(vo.toPrint());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MemberDaoTest main=new MemberDaoTest();
		
		//회원파일 읽기
		//main.getMemberDataRead();
		
		//회원가입
		//main.doSave();
		
		//회원조회
		//main.doSelectOne();
		
		//회원수정
		//main.doUpdate();
		
		//회원삭제
		//main.doDelete();
		
		//목록 조회
		main.doRetrieve();
		
		
		//회원파일 쓰기
		//main.writeMemberData();

	}

}
