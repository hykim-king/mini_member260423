/**
 * 파일명: PLogger.java <br>
 * 설명 : 공통로거  <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-23 <br>
 */
package com.pcwk.cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Log4j2 로거
 */
public interface PLogger {
	static final Logger log = LogManager.getLogger(PLogger.class);
	
}
