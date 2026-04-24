/**
 * 파일명: DTO.java <br>
 * 설 명: 모든 Value Object의 Parent <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-23 <br>
 */
package com.pcwk.cmn;

/**
 * Data Transfer Object, 데이터 전송 객체
 */
public class DTO {

	private int no;// 글번호
	private String searchDiv;// 검색구분
	private String searchWord;// 검색어
	
	public DTO() {
		super();

	}

	public DTO(String searchDiv, String searchWord) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
	}

	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the searchDiv
	 */
	public String getSearchDiv() {
		return searchDiv;
	}

	/**
	 * @param searchDiv the searchDiv to set
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	/**
	 * @return the searchWord
	 */
	public String getSearchWord() {
		return searchWord;
	}

	/**
	 * @param searchWord the searchWord to set
	 */
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public String toString() {
		return "DTO [no=" + no + "]";
	}

	
	
}
