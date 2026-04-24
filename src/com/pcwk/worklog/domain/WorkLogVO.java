/**
 * 파일명: WorkLogVO.java       <br>
 * 설명 : 업무일지 Value Object   <br>
 * 작성자: user <br>
 * 생성일: 2026-04-24 <br>
 */
package com.pcwk.worklog.domain;

import java.util.Objects;

import com.pcwk.cmn.DTO;

public class WorkLogVO extends DTO {
	
	private String  logId     ;//업무일지_ID(Key)
	private String  memberId  ;//작성자_ID
	private String  workDate  ;//업무일자
	private String  title     ;//제목
	private String  content   ;//업무내용
	private String  regDate   ;//등록일
	
	
	public WorkLogVO() {
		
	}


	public WorkLogVO(String logId, String memberId, String workDate, String title, String content, String regDate) {
		super();
		this.logId = logId;
		this.memberId = memberId;
		this.workDate = workDate;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(logId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkLogVO other = (WorkLogVO) obj;
		return Objects.equals(logId, other.logId);
	}	

	/**
	 * csv format 문자열
	 * 업무일지_ID,작성자_ID,업무일자,제목,업무내용,등록일
	 * @return
	 */
	public String toCsv() {
		//업무일지_ID,작성자_ID,업무일자,제목,업무내용,등록일
		//System.out.printf("포맷문자열",...가변인자)
		//=String.format(
		return String.format("%s,%s,%s,%s,%s,%s", logId
												, memberId
												, workDate
												, title
												, content
												, regDate
												);
	}
	
	/**
	 * 내용을 제외(상세조회에서 출력)
	 * @return format 문자 
	 */
	public String toPrint() {
		return String.format("%-40s,%-15s,%-10s,%-20s,%-10s", logId
															, memberId
															, workDate
															, title
															, regDate
															);
	}
	
	
	/**
	 * @return the logId
	 */
	public String getLogId() {
		return logId;
	}


	/**
	 * @param logId the logId to set
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}


	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}


	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	/**
	 * @return the workDate
	 */
	public String getWorkDate() {
		return workDate;
	}


	/**
	 * @param workDate the workDate to set
	 */
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}


	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "WorkLogVO [logId=" + logId + ", memberId=" + memberId + ", workDate=" + workDate + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
