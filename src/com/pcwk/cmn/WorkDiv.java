/**
 * 파일명: WorkDiv.java <br>
 * 설명 : DAO표준 
 * 작성자: user  <br>
 * 생성일: 2026-04-23 <br>
 */
package com.pcwk.cmn;

import java.util.List;

/**
 * DAO CRUD메서드 정의
 */
public interface WorkDiv {

	/**
	 * 회원 등록을 수행한다.
	 * 화면에서 입력을 받아 서비스에 전달하고 결과를 출력한다.
	 * @param param
	 * @return 1:성공,0:실패
	 */
	int doSave(DTO param);

	/**
	 * 회원 수정을 수행한다.
	 * 수정할 회원 정보를 입력받아 서비스에 전달한다.
	 * @param param
	 * @return 1:성공,0:실패
	 */
	int doUpdate(DTO param);

	/**
	 * 회원 삭제를 수행한다.
	 * 회원ID를 입력받아 삭제 처리 후 결과를 출력한다.
	 * @param param
	 * @return 1:성공,0:실패
	 */
	int doDelete(DTO param);

	/**
	 * 회원 단건 조회를 수행한다.
	 * 회원ID를 기준으로 회원 정보를 조회하여 화면에 출력한다.
	 * @param param
	 * @return DTO
	 */
	DTO doSelectOne(DTO param);

	/**
	 * 회원 목록 조회를 수행한다.
	 * 검색 조건을 입력받아 목록을 조회하고 결과를 출력한다.
	 * @param param
	 * @return List<DTO>
	 */
	List<DTO> doRetrieve(DTO param);
}
