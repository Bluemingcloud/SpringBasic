package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.simple.basic.command.ScoreVO;

@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {
	
	//DB라 가정
	//ArrayList<ScoreVO> list = new ArrayList<>(); 
	@Autowired
	@Qualifier("ds")
	private DataSource ds;
	
	@Override
	public void regist(ScoreVO vo) {
		
		//list.add(vo); // insert 완료
		
		// insert 작업...
		
	}
	
	@Override
	public ArrayList<ScoreVO> getList() {
		
		//return list;
		
		// select 작업...
		return null;
		
	}
	
	@Override
	public void delete(int sno) {
		
		//list.remove(sno);
		
		// delete 작업...
		
	}
}
