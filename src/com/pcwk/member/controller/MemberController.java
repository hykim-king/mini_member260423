/**
 * 파일명: MemberController.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-27 <br>
 */
package com.pcwk.member.controller;

import java.util.List;
import java.util.Scanner;

import com.pcwk.cmn.DTO;
import com.pcwk.member.domain.MemberVO;
import com.pcwk.member.service.MemberService;
import com.pcwk.member.service.MemberServiceImpl;
import com.pcwk.member.view.MemberInputView;
import com.pcwk.member.view.MemberResultView;
import com.pcwk.member.view.MenuView;

/**
 * 
 */
public class MemberController {

	private MemberService  service;
	private Scanner  scanner;
	
	
	public MemberController() {
		service = new MemberServiceImpl();
		scanner = new Scanner(System.in);
	}

	/**
	 * 회원등록
	 */
	private void doSave() {
		//회원등록
		MemberResultView.printTitle("회원등록");
		
		//회원정보입력
		MemberVO inVO =MemberInputView.inputMemberForSave(scanner);
		
		//회원등록 서비스 호출
		int flag = service.addMember(inVO);
		switch(flag) {
		case 1:
			MemberResultView.printMessage("회원등록 성공");
			break;
		case 2:
			MemberResultView.printMessage("회원ID 중복");
			break;
		default:
			MemberResultView.printMessage("회원등록 실패");
			break;
		}
	}
	/**
	 * 회원수정
	 */
	private void doUpdate() {
		MemberResultView.printTitle("회원수정");
		
		MemberVO inVO=MemberInputView.inputMemberForUpdate(scanner);
		//회원수정 서비스 호출
		int flag = service.updateMember(inVO);
		//0:실패,2:회원없음,3:성공
		//System.out.println("flag: "+flag);
		switch(flag) {
		case 3:
			MemberResultView.printMessage("회원수정 성공");
			
			break;
		case 2:
			MemberResultView.printMessage("수정 대상 회원 없습니다.");
			break;
		default:
			MemberResultView.printMessage("회원수정 실패");
			break;
		}
		
		
	}
	
	private void doDelete() {
		MemberResultView.printTitle("회원삭제");
		String memberId = MemberInputView.inputMemberId(scanner);
		
		//회원삭제 서비스 호출
		int flag = service.deleteMember(memberId);
		
		switch(flag) {
		case 1:
			MemberResultView.printMessage("회원삭제 성공");
			break;
			
		case 2:
			MemberResultView.printMessage("삭제대상 회원이 없습니다.");
			break;
		default:
			MemberResultView.printMessage("회원삭제 실패");
			break;
			
		}
		
	}
	
	private void doSelectOne() {
		MemberResultView.printTitle("회원 단건 조회");
		//회원ID입력
		String memberId = MemberInputView.inputMemberId(scanner);
		
		//회원단건 조회 서비스 호출
		MemberVO outVO = service.findMember(memberId);
		if(null != outVO) {
			MemberResultView.printMember(outVO);
		}else {
			MemberResultView.printMessage("조회 대상 회원이 없습니다.");
		}
		
	}
	
	private void doRetrieve() {
		MemberResultView.printTitle("회원 목록 조회");
		DTO search = MemberInputView.inputSearch(scanner);
		
		//회원목록 조회 서비스 호출
		List<MemberVO>   list = service.findMembers(search);
		
		if(null == list || list.isEmpty()) {
			MemberResultView.printMessage("조회 결과가 없습니다.");
			return;
		}
		
		MemberResultView.printMembers(list);
		
	}
	
	private void doSaveFile() {
		MemberResultView.printTitle("회원 파일 저장");
		
		int count = service.saverMembersToFile();
		if(count>0) {
			MemberResultView.printMessage("파일 저장 성공: "+count+"건");
		}else {
			MemberResultView.printMessage("파일 저장 완료(저장 건수 0)");
		}
	}
	//프로그램 시작
	public void run() {
		
		boolean running = true;
		
		while(running) {
			MenuView.printMainMenu();//메뉴
			int menuNo = MemberInputView.inputMenu(scanner);
			
			switch(menuNo) {
			case 1://1. 회원등록
				doSave();
				break;
			case 2://2. 회원수정
				doUpdate();
				break;
			case 3://3. 회원삭제
				doDelete();
				break;			
			case 4://4. 회원 단건조회	
				doSelectOne();
				break;
			case 5://5. 회원 목록 조회
				doRetrieve();
				break;
			case 6://6. 파일 저장
				doSaveFile();
				break;	
			case 0:
				running = false;
				//프로그램 종료
				MemberResultView.printMessage("프로그램 종료");
				break;
			default:
				//잘못된 메뉴입니다.
				MemberResultView.printMessage("잘못된 메뉴입니다.");
				break;
			}
			
			//파일에 저장
			if(menuNo!=6) { //6은 제외
				service.saverMembersToFile();
			}
		}
		
		scanner.close();
		
	}
	
}
