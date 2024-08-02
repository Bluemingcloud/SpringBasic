package com.simple.basic.service.score;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.impl.ScoreDAO;

@Service("scoreService") // 반드시 component-scan에 의하여 읽혀야 함
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	@Qualifier("scoreDAO")
	ScoreDAO dao;
	
	@Override
	public void regist(ScoreVO vo) {
		// Service Layer 에서 DAO Layer 로...
		dao.regist(vo);
		System.out.println("service layer : " + vo.toString());
	}
	
	@Override
	public ArrayList<ScoreVO> getList() {
		
		return dao.getList();
	}
	
}
