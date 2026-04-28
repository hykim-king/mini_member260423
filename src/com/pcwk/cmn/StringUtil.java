/**
 * 파일명: StringUtil.java <br>
 * 설명 : 문자열 Util <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-27 <br>
 */
package com.pcwk.cmn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 문자열 Util
 */
public class StringUtil {

	/**
	 * 문자열 데이터가 null,비어 있는지 확인
	 * @param str
	 * @return true(null 이거나 비어있음)/false
	 */
	public static boolean isBlank(String str) {
		return null == str || str.trim().isEmpty();
	}

	/**
	 * 당일 날짜 format지정: "yyyy/MM/dd"
	 * @param format
	 * @return "yyyy/MM/dd"
	 */
	public static String formatDate(String format) {
		if(isBlank(format)) {
			format = "yyyy/MM/dd";
		}
		//가입일: 오늘(yyyy/MM/dd)
		LocalDate now=LocalDate.now();
		//형식지정
		String formattedDate=now.format(DateTimeFormatter.ofPattern(format));	
		
		return formattedDate;
	}
}
 