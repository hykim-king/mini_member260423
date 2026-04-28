/**
 * 파일명: MemberInputView.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-27 <br>
 */
package com.pcwk.member.view;

import java.util.Scanner;

import com.pcwk.cmn.DTO;
import com.pcwk.cmn.PLogger;
import com.pcwk.member.domain.MemberVO;

/**
 * 메뉴, 회원 입력
 */
public class MemberInputView implements PLogger {


	public MemberInputView() {
		// TODO Auto-generated constructor stub
	}

	
	public static DTO inputSearch(Scanner  scanner) {
		DTO search=new DTO();
		
		System.out.println("검색구분: ALL(전체),10(회원ID),20(이름),30(이메일)");
		System.out.print("검색구분 > ");
		search.setSearchDiv(scanner.nextLine());
		
		System.out.print("검색어 > ");
		search.setSearchWord(scanner.nextLine());
		return search;
	}
	
	
	public static String inputMemberId(Scanner  scanner) {
		String memberId = "";
		System.out.print("회원ID > ");
		memberId = scanner.nextLine();
		
		return memberId;
	}
	public static MemberVO inputMemberForUpdate(Scanner  scanner) {
		MemberVO vo=new MemberVO();
		
		System.out.print("수정할 회원ID > ");
		vo.setMemberId(scanner.nextLine());
		
		System.out.print("이름 > ");
		vo.setName(scanner.nextLine());
		
		System.out.print("비밀번호 > ");
		vo.setPassword(scanner.nextLine());
		
		System.out.print("이메일 > ");
		vo.setEmail(scanner.nextLine());
        //TODO 회원정보 조회에서 가지고 올것		
		System.out.print("가입일 > ");
		vo.setRegDate(scanner.nextLine());		
		
		
		System.out.print("권한(일반/관리자) > ");
		vo.setRole(scanner.nextLine());		
		
		return vo;
	}
	
	public static MemberVO inputMemberForSave(Scanner  scanner) {
		MemberVO vo=new MemberVO();
		
		System.out.print("회원ID > ");
		vo.setMemberId(scanner.nextLine());
		
		System.out.print("이름 > ");
		vo.setName(scanner.nextLine());
		
		System.out.print("비밀번호 > ");
		vo.setPassword(scanner.nextLine());
		
		System.out.print("이메일 > ");
		vo.setEmail(scanner.nextLine());
		
		System.out.print("권한(일반/관리자) > ");
		vo.setRole(scanner.nextLine());
		
		return vo;
	}
	
	public static int inputMenu(Scanner  scanner) {
		System.out.print("메뉴 선택 >");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);//숫자형 문자를 숫자(int)로 변화
		}catch(NumberFormatException e) {
			log.error("NumberFormatException: {}",e);
			return -1;
		}
	}
}
