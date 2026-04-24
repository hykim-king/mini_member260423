/**
 * 파일명: MenuView.java  <br>
 * 설명:  <br>
 * 작성자: user <br>
 * 작성일: 2026. 4. 24. <br>
 * 버전 : 1.0
 */
package com.pcwk.member.view;

/**
 * 
 */
public class MenuView {

    private MenuView() {
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println("==================================");
        System.out.println("      회원 관리 프로그램");
        System.out.println("==================================");
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 수정");
        System.out.println("3. 회원 삭제");
        System.out.println("4. 회원 단건 조회");
        System.out.println("5. 회원 목록 조회");
        System.out.println("6. 파일 저장");
        System.out.println("0. 종료");
        System.out.println("==================================");
    }
}
