package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.gbDao.GbDao;
import com.javaex.gbVo.GbVo;

@Service
public class GbService {
	
	@Autowired
	private GbDao gbDao; 
	
	public void gbInsert(GbVo gv) {
		
		gbDao.gbinsert(gv);
		
	}
	
	public List<GbVo> gbList() {
		List<GbVo> gList = gbDao.gblist();
		
		return gList;
	}
	
	public void gbDelete(int no, String pw) {
		gbDao.gbdelete(no, pw);
	}
}
