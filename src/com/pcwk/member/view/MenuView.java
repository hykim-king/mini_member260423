/**
 * 파일명: MenuView.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-27 <br>
 */
package com.pcwk.member.view;

/**
 * Main 메뉴 출력
 */
public class MenuView {


	public MenuView() {
		// TODO Auto-generated constructor stub
	}
	
	public static void printMainMenu() {

		System.out.println();
		System.out.println("┌──────────────────────────────────────────────");
		System.out.println("│ 회원관리 프로그램                                ");
		System.out.println("└──────────────────────────────────────────────");
		System.out.println("│1. 회원등록");
		System.out.println("│2. 회원수정");
		System.out.println("│3. 회원삭제");
		System.out.println("│4. 회원 단건조회");
		System.out.println("│5. 회원 목록 조회");
		System.out.println("│6. 파일 저장");
		System.out.println("│0. 종료");	
		System.out.println("└──────────────────────────────────────────────");
		
	}	

}
