/**
 * 파일명: MemberService.java  <br>
 * 설명:  <br>
 * 작성자: user <br>
 * 작성일: 2026. 4. 24. <br>
 * 버전 : 1.0
 */
package com.pcwk.member.service;

import java.util.List;

import com.pcwk.cmn.DTO;
import com.pcwk.member.domain.MemberVO;

/**
 * 
 */
public interface MemberService {
	/**
	 * 회원 등록을 수행한다.
	 * 화면에서 입력을 받아 서비스에 전달하고 결과를 출력한다.
	 * @param param
     * @return 1:성공,0:실패,2:기존회원 존재
	 */
    int addMember(MemberVO param);

	/**
	 * 회원 수정을 수행한다.
	 * 수정할 회원 정보를 입력받아 서비스에 전달한다.
	 * @param param
	 * @return 0:실패,2:회원없음,3:성공
	 */    
    int updateMember(MemberVO param);

	/**
	 * 회원 삭제를 수행한다.
	 * 회원ID를 입력받아 삭제 처리 후 결과를 출력한다.
	 * @param param
	 * @return 1:성공,0:실패
	 */    
    int deleteMember(String memberId);

	/**
	 * 회원 단건 조회를 수행한다.
	 * 회원ID를 기준으로 회원 정보를 조회하여 화면에 출력한다.
	 * @param param
	 * @return T
	 */    
    MemberVO findMember(String memberId);

	/**
	 * 회원 목록 조회를 수행한다.
	 * 검색 조건을 입력받아 목록을 조회하고 결과를 출력한다.
	 * @param param
	 * @return List<T>
	 */
    List<MemberVO> findMembers(DTO search);

    /**
     * 회원 정보를 member.csv에 저장 합니다.
     * @return 저장된 회원수 
     */
    int saveMembersToFile();
}
