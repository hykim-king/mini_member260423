/**
 * 파일명: ResultView.java  <br>
 * 설명:  <br>
 * 작성자: user <br>
 * 작성일: 2026. 4. 24. <br>
 * 버전 : 1.0
 */
package com.pcwk.member.view;

import java.util.List;

import com.pcwk.member.domain.MemberVO;

/**
 * 
 */
public class ResultView {

	private ResultView() {
	}

	public static void printTitle(String title) {
		System.out.println();
		System.out.println("==================================");
		System.out.println("[" + title + "]");
		System.out.println("==================================");
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printMember(MemberVO vo) {
		if (vo == null) {
			System.out.println("출력할 회원 정보가 없습니다.");
			return;
		}

		System.out.println("회원ID : " + vo.getMemberId());
		System.out.println("이름   : " + vo.getName());
		System.out.println("비밀번호: " + maskPassword(vo.getPassword()));
		System.out.println("이메일 : " + vo.getEmail());
		System.out.println("가입일 : " + vo.getRegDate());
		System.out.println("권한   : " + vo.getRole());
	}

	public static void printMemberList(List<MemberVO> list) {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("%-12s %-10s %-12s %-25s %-12s %-10s%n", "회원ID", "이름", "비밀번호", "이메일", "가입일", "권한");
		System.out.println("--------------------------------------------------------------------------------");

		for (MemberVO vo : list) {
			System.out.printf("%-12s %-10s %-12s %-25s %-12s %-10s%n", vo.getMemberId(), vo.getName(),
					maskPassword(vo.getPassword()), vo.getEmail(), vo.getRegDate(), vo.getRole());
		}

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("총 건수: " + list.size());
	}

	private static String maskPassword(String password) {
		if (password == null || password.isEmpty()) {
			return "";
		}
		return "*".repeat(password.length());
	}
}
