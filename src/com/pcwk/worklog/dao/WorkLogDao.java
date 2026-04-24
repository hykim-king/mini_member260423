/**
 * 파일명: WorkLogDao.java <br>
 * 설명 : 업무일지 Dao  <br>
 * 작성자: user  <br>
 * 생성일: 2026-04-24 <br>
 */
package com.pcwk.worklog.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pcwk.cmn.DTO;
import com.pcwk.cmn.PLogger;
import com.pcwk.cmn.WorkDiv;
import com.pcwk.worklog.domain.WorkLogVO;

/**
 * 
 */
public class WorkLogDao implements WorkDiv<WorkLogVO>,PLogger {

	//파일이름
	public static final String WORK_LOG_DATA= "D:\\CJFS_20260324\\01_JAVA1\\WORKSPACE\\mini_260423\\data\\work_log.csv";
	
	//업무일지 ArrayList
	private List<WorkLogVO> workLogs = new ArrayList<WorkLogVO>();
	
	
	public WorkLogDao() {
		super();
		getWorkLogDataRead(WorkLogDao.WORK_LOG_DATA);
	}
	
	public int getWorkLogDataRead(String path) {
		int count =0;//총 업무일지 수 
		//업무일지_ID,작성자_ID,업무일자,제목,업무내용,등록일
		
		try(BufferedReader  br=new BufferedReader(new FileReader(path))){
		
			String line = "";
			int i = 1;
			
			while( (line=br.readLine()) !=null) {
				
				if(i == 1) {// 첫 줄은 header이므로 읽지 않는다.
					log.debug("{}",line);
					i++;
					continue;
				}
				count++;
				//1,pcwk01,2026/04/24,Java업무1,mini프로젝트1,2026/04/24
				String[] strArray = line.split(",");
				
				if (strArray.length == 6) {
					
					WorkLogVO  workLog=new WorkLogVO(strArray[0], strArray[1], strArray[2], 
							                         strArray[3], strArray[4], strArray[5]);
					log.debug("{},{}",count,workLog.toString() );
					
					this.workLogs.add(workLog);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException: {}", e);
		} catch (IOException e) {
			log.error("IOException: {}", e);
		} catch (Exception e) {
			log.error("Exception: {}", e);
		}
		
		
		return count;
	}
	

	@Override
	public int doSave(WorkLogVO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(WorkLogVO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(WorkLogVO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WorkLogVO doSelectOne(WorkLogVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkLogVO> doRetrieve(DTO param) {
		// TODO Auto-generated method stub
		return null;
	}

}
