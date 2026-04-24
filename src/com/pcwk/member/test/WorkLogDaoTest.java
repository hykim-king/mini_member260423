/**
 * 파일명: WorkLogDaoTest.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-24 <br>
 */
package com.pcwk.member.test;

import com.pcwk.cmn.DTO;
import com.pcwk.worklog.dao.WorkLogDao;
import com.pcwk.worklog.domain.WorkLogVO;

/**
 * 
 */
public class WorkLogDaoTest {

	WorkLogDao dao;//업무일지 Dao
	WorkLogVO  workLog01;//업무일지 CRUD param
	DTO        dto; //검색
	
	/**
	 * 
	 */
	public WorkLogDaoTest() {
		dao = new WorkLogDao();
		workLog01 = new WorkLogVO("5","pcwk05","2026/04/24","Java업무5","mini프로젝트5","2026/04/24");
		
		dto = new DTO();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WorkLogDaoTest main=new WorkLogDaoTest();

	}

}
