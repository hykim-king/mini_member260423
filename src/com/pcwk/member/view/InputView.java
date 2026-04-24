/**
 * 파일명: InputView.java  <br>
 * 설명:  <br>
 * 작성자: user <br>
 * 작성일: 2026. 4. 24. <br>
 * 버전 : 1.0
 */
package com.pcwk.member.view;

import java.util.Scanner;

import com.pcwk.cmn.DTO;
import com.pcwk.member.domain.MemberVO;

/**
 * 
 */
public class InputView {

	private InputView() {
	}

	public static int inputMenu(Scanner scanner) {
		System.out.print("메뉴 선택 > ");
		String input = scanner.nextLine();

		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public static MemberVO inputMemberForSave(Scanner scanner) {
		MemberVO vo = new MemberVO();

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

	public static MemberVO inputMemberForUpdate(Scanner scanner) {
		MemberVO vo = new MemberVO();

		System.out.print("수정할 회원ID > ");
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

	public static String inputMemberId(Scanner scanner) {
		System.out.print("회원ID > ");
		return scanner.nextLine();
	}

	public static DTO inputSearch(Scanner scanner) {
		DTO search = new DTO();

		System.out.println("검색구분: ALL(전체), 10(회원ID), 20(이름), 30(이메일)");
		System.out.print("검색구분 > ");
		search.setSearchDiv(scanner.nextLine());

		System.out.print("검색어 > ");
		search.setSearchWord(scanner.nextLine());

		return search;
	}
}
