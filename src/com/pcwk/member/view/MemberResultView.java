/**
 * 파일명: MemberResultView.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-27 <br>
 */
package com.pcwk.member.view;

import java.util.List;

import com.pcwk.member.domain.MemberVO;

/**
 * 
 */
public class MemberResultView {


	public MemberResultView() {
		
	}
	
	//세부 기능 제목
	public static void printTitle(String title) {
		System.out.println();
		System.out.println("==============================");
		System.out.println("["+title+"]");
		System.out.println("==============================");
	}
	
	
	public static void printMembers(List<MemberVO> list) {
    	System.out.printf("%-15s|%-7s|%-20s|%-20s|%-10s|%-3s\n","회원ID"
    			,"이름"
    			,"비밀번호"
    			,"이메일"
    			,"가입일"
    			,"등급"
    			);
        System.out.println("==================================================================================================");
        for(MemberVO vo    :list) {
        	System.out.printf(vo.toPrint()+"\n");
        }
        System.out.println("==================================================================================================");
        System.out.println("총 건수: "+list.size());
        
	}
	
	/**
	 *  회원 단건 조회 출력
	 * @param vo
	 */
    public static void printMember(MemberVO vo) {
    	if(null == vo) {
    		System.out.println("출력할 회원 정보가 없습니다.");
    		return;
    	}
    	System.out.printf("%-15s|%-7s|%-20s|%-20s|%-10s|%-3s\n","회원ID"
											    			,"이름"
											    			,"비밀번호"
											    			,"이메일"
											    			,"가입일"
											    			,"등급"
											    			);
    	System.out.println("==================================================================================================");
    	System.out.printf(vo.toPrint()+"\n");
    }
	
	
	//결과 메시지: 
	public static void printMessage(String message) {
		System.out.println(message);
	}

}
