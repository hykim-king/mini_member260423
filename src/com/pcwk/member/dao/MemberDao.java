/**
 * 파일명: MemberDao.java <br>
 * 설명 :   <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-23 <br>
 */
package com.pcwk.member.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pcwk.cmn.DTO;
import com.pcwk.cmn.PLogger;
import com.pcwk.cmn.StringUtil;
import com.pcwk.cmn.WorkDiv;
import com.pcwk.member.domain.MemberVO;

/**
 * 회원 Data Access Object
 */
public class MemberDao implements WorkDiv<MemberVO>, PLogger {

	// 파일이름
	public static final String MEMBER_DATA = "D:\\CJFS_20260324\\01_JAVA1\\WORKSPACE\\mini_260423\\data\\member.csv";

	// 회원 ArrayList
	public static List<MemberVO> members = new ArrayList<MemberVO>();

	public MemberDao() {
		int memberCount = getMemberDataRead(MemberDao.MEMBER_DATA);
	}

	/**
	 * ArrayList<MemberVO>를 파일에 기록 합니다.
	 * 
	 * @param path
	 * @return 회원 수
	 */
	public int writeMemberData(String path) {
		int count = 0;
		String divStr = ",";// 데이터 구분자
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			// header생성 1회
			String header = "회원ID,이름,비밀번호,이메일,가입일,권한";
			bw.write(header);
			bw.newLine();
			log.debug("header: {}", header);
			for (MemberVO vo : members) {
				count++;
				log.debug("{},{}", count, vo.toCsv());
				bw.write(vo.toCsv());
				bw.newLine();
			}

		} catch (IOException e) {
			log.debug("IOException: {}", e);
		} catch (Exception e) {
			log.debug("Exception: {}", e);
		}

		return count;
	}

	/**
	 * Member.csv파일 읽기
	 * 
	 * @param path
	 * @return 회원 인원수
	 */
	public int getMemberDataRead(String path) {

		int count = 0;// 회원수

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//			회원ID,이름,비밀번호,이메일,가입일,권한

			String line = "";
			int i = 1;
			while ((line = br.readLine()) != null) {

				if (i == 1) { // 첫 줄은 header이므로 읽지 않는다.

					log.debug("{}", line);
					i++;
					continue;
				}

				count++;
				String[] strArray = line.split(",");
				if (strArray.length == 6) {
					MemberVO member = new MemberVO(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4],
							strArray[5]);
					log.debug("{},{}", count, member.toString());

					members.add(member);
				}

			}

		} catch (ArrayIndexOutOfBoundsException e) {
			log.error("ArrayIndexOutOfBoundsException: {}", e);
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException: {}", e);
		} catch (IOException e) {
			log.error("IOException: {}", e);
		} catch (Exception e) {
			log.error("Exception: {}", e);
		}

		return count;
	}

	/**
	 * 회원ID 존재 확인
	 * 
	 * @param param
	 * @return true:존재, false: 없음
	 */
	public boolean isExistsMember(MemberVO param) {
		boolean flag = false;

		for (MemberVO vo : members) {
			if (vo.getMemberId().equals(param.getMemberId())) {
				// if(vo.equals(param)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	@Override
	public int doSave(MemberVO param) {
		int flag = 0;
		// 기존 회원ID가 존재하면 : 1:성공,0:실패,2:기존회원 존재

		if (isExistsMember(param) == true) {
			flag = 2;

			return flag;
		}

		flag = this.members.add(param) == true ? 1 : 0;
		log.debug("등록여부: {}", flag);

		return flag;
	}

	@Override
	public int doUpdate(MemberVO param) {
		int flag = 0;
		// 기존 데이터 존재 확인
		// 존재하면: 삭제, 저장

		if (isExistsMember(param) == false) {
			flag = 2;// 기존 회원 없음!
			return flag;
		}

		// isDeleted : 1이면 성공
		int isDeleted = doDelete(param);
		flag = isDeleted;// 삭제 성공

		if (1 == isDeleted) {
			// 1이면 성공
			int isSaved = doSave(param);
			flag = isDeleted + isSaved + 1;
			log.debug("doUpdate: {}", flag);
		}

		return flag;
	}

	@Override
	public int doDelete(MemberVO param) {
		int flag = 0;
		// 기존 회원ID가 존재하면 : 1:성공,0:실패,2:기존회원 존재
		if (isExistsMember(param) == false) {
			flag = 2;// 회원 없음
			return flag;
		}

		// 삭제
		Iterator<MemberVO> iter = members.iterator();

		while (iter.hasNext()) {
			MemberVO vo = iter.next();

			if (vo.getMemberId().equals(param.getMemberId())) {
				// 삭제
				iter.remove();// 안전한 삭제
				flag = 1;
				break;
			}
		}

		return flag;
	}

	@Override
	public MemberVO doSelectOne(MemberVO param) {
		MemberVO outVO = null;

		// 향상된 for
		for (MemberVO memberVO : members) {
			if (memberVO.getMemberId().equals(param.getMemberId())) {
				outVO = memberVO;
				log.debug("doSelectOne:{}", outVO);
				break;
			}
		}

		return outVO;
	}

	// 
	/**
	 *  조건을 별도 메서드로 
	 * @param div : 검색구분
	 * @param word: 검색어
	 * @param vo  : MemberVO
	 * @return true/false
	 */
	private boolean match(String div, String word, MemberVO vo) {

		switch (div) {
		case "10":// 회원ID
			return vo.getMemberId().contains(word);

		case "20":// 이름
			return vo.getName().contains(word);
			
		case "30":// 이메일
			return vo.getEmail().contains(word);			
		default:
			return false;
		}
	}

	@Override
	public List<MemberVO> doRetrieve(DTO param) {
		// 회원 검색조건
		// "ALL": 전체
		// 10: 회원ID
		// 20: 이름
		// 30: 이메일
		log.debug("DTO(검색조건): {}", param);

		// 조회결과
		ArrayList<MemberVO> outList = new ArrayList<MemberVO>();

		String div = param.getSearchDiv();
		String word = param.getSearchWord();
		
		if(StringUtil.isBlank(div) || "ALL".equalsIgnoreCase(div)) {
			return this.members;
		}
		
		//10:회원ID,20:이름,30:이메일
		for(MemberVO vo : this.members) {
			if(match(div,word,vo) == true) {
				outList.add(vo);
			}
		}


		return outList;
	}

}
