/**
 * 파일명: MemberVO.java <br>
 * 설명 :  회원관리  <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-23 <br>
 */
package com.pcwk.member.domain;

import java.util.Objects;

import com.pcwk.cmn.DTO;

/**
 * 회원관리 Value Object
 */
public class MemberVO extends DTO {

	private String memberId;// 회원ID
	private String name;// 이름
	private String password;// 비밀번호
	private String email;// 이메일
	private String regDate;// 가입일
	private String role;// 권한

	public MemberVO() {

	}

	public MemberVO(String memberId, String name, String password, String email, String regDate, String role) {
		super();
		this.memberId = memberId;
		this.name     = name;
		this.password = password;
		this.email    = email;
		this.regDate  = regDate;
		this.role     = role;
	}

	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(memberId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(memberId, other.memberId);
	}

	/**
	 * csv format 문자열
	 * @return "회원ID,이름,비밀번호,이메일,가입일,권한"
	 */
	public String toCsv() {
	    //"회원ID,이름,비밀번호,이메일,가입일,권한"
		return String.format("%s,%s,%s,%s,%s,%s", memberId
				                                , name    
				                                , password
				                                , email   
				                                , regDate 
				                                , role );
	}	
	
	/**
	 * 전체내용
	 * @return format 문자 
	 */	
	public String toPrint() {
		return String.format("%-15s|%-7s|%-20s|%-20s|%-10s|%-3s", memberId
                , name    
                , password
                , email   
                , regDate 
                , role );		
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", regDate=" + regDate + ", role=" + role + ", toString()=" + super.toString() + "]";
	}



	
	
}
