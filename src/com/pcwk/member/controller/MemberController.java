/**
 * 파일명: MemberController.java  <br>
 * 설명:  <br>
 * 작성자: user <br>
 * 작성일: 2026. 4. 24. <br>
 * 버전 : 1.0
 */
package com.pcwk.member.controller;

import java.util.List;
import java.util.Scanner;

import com.pcwk.cmn.DTO;
import com.pcwk.member.domain.MemberVO;
import com.pcwk.member.service.MemberService;
import com.pcwk.member.service.MemberServiceImpl;
import com.pcwk.member.view.InputView;
import com.pcwk.member.view.MenuView;
import com.pcwk.member.view.ResultView;

/**
 * 
 */
public class MemberController {

    private final MemberService service;
    private final Scanner scanner;

    public MemberController() {
        this.service = new MemberServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            MenuView.printMainMenu();
            int menuNo = InputView.inputMenu(scanner);

            switch (menuNo) {
                case 1:
                    doSave();
                    break;
                case 2:
                    doUpdate();
                    break;
                case 3:
                    doDelete();
                    break;
                case 4:
                    doSelectOne();
                    break;
                case 5:
                    doRetrieve();
                    break;
                case 6:
                    doSaveFile();
                    break;
                case 0:
                    running = false;
                    ResultView.printMessage("프로그램을 종료합니다.");
                    break;
                default:
                    ResultView.printMessage("잘못된 메뉴입니다.");
                    break;
            }
        }

        scanner.close();
    }

    private void doSave() {
        ResultView.printTitle("회원 등록");
        MemberVO inVO = InputView.inputMemberForSave(scanner);

        int flag = service.addMember(inVO);

        switch (flag) {
            case 1:
                ResultView.printMessage("회원 등록 성공");
                break;
            case 2:
                ResultView.printMessage("회원ID 중복");
                break;
            default:
                ResultView.printMessage("회원 등록 실패");
                break;
        }
    }

    private void doUpdate() {
        ResultView.printTitle("회원 수정");
        MemberVO inVO = InputView.inputMemberForUpdate(scanner);

        int flag = service.updateMember(inVO);

        switch (flag) {
            case 1:
                ResultView.printMessage("회원 수정 성공");
                break;
            case 2:
                ResultView.printMessage("수정 대상 회원이 없습니다.");
                break;
            default:
                ResultView.printMessage("회원 수정 실패");
                break;
        }
    }

    private void doDelete() {
        ResultView.printTitle("회원 삭제");
        String memberId = InputView.inputMemberId(scanner);

        int flag = service.deleteMember(memberId);

        switch (flag) {
            case 1:
                ResultView.printMessage("회원 삭제 성공");
                break;
            case 2:
                ResultView.printMessage("삭제 대상 회원이 없습니다.");
                break;
            default:
                ResultView.printMessage("회원 삭제 실패");
                break;
        }
    }

    private void doSelectOne() {
        ResultView.printTitle("회원 단건 조회");
        String memberId = InputView.inputMemberId(scanner);

        MemberVO outVO = service.findMember(memberId);

        if (outVO != null) {
            ResultView.printMember(outVO);
        } else {
            ResultView.printMessage("조회 대상 회원이 없습니다.");
        }
    }

    private void doRetrieve() {
        ResultView.printTitle("회원 목록 조회");
        DTO search = InputView.inputSearch(scanner);

        List<MemberVO> list = service.findMembers(search);

        if (list == null || list.isEmpty()) {
            ResultView.printMessage("조회 결과가 없습니다.");
            return;
        }

        ResultView.printMemberList(list);
    }

    private void doSaveFile() {
        ResultView.printTitle("회원 파일 저장");

        int count = service.saveMembersToFile();

        if (count > 0) {
            ResultView.printMessage("파일 저장 성공: " + count + "건");
        } else {
            ResultView.printMessage("파일 저장 완료(저장 건수 0)");
        }
    }
}
