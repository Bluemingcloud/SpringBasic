package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.basic.command.ScoreVO;

@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {
	
	//DB라 가정
	ArrayList<ScoreVO> list = new ArrayList<>(); 
	
	@Override
	public void regist(ScoreVO vo) {
		
		list.add(vo); // insert 완료
		System.out.println("repository layer:" + vo.toString());
	}
	
	@Override
	public ArrayList<ScoreVO> getList() {
		return list;
	}
	
}
