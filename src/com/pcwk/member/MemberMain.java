/**
 * 파일명: MemberMain.java  <br>
 * 설명:  회원관리 Main<br>
 * 작성자: user <br>
 * 작성일: 2026. 4. 24. <br>
 * 버전 : 1.0
 */
package com.pcwk.member;

import com.pcwk.member.controller.MemberController;

/**
 * 회원관리 Main
 */
public class MemberMain {

    public static void main(String[] args) {
        MemberController controller = new MemberController();
        controller.run();
    }
}
