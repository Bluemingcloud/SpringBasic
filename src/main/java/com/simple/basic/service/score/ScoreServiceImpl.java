package com.simple.basic.service.score;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.impl.ScoreDAO;

@Service("scoreService") // 반드시 component-scan에 의하여 읽혀야 함
public class ScoreServiceImpl implements ScoreService {

//	@Autowired
//	@Qualifier("scoreDAO")
//	ScoreDAO scoreDAO;
	
	@Autowired
	private ScoreMapper scoreMapper;
	
	@Override
	public void regist(ScoreVO vo) {
		// Service Layer 에서 DAO Layer 로...
		//scoreDAO.regist(vo);
		//System.out.println("service layer : " + vo.toString());
		
		scoreMapper.regist(vo);
	}
	
	@Override
	public ArrayList<ScoreVO> getList() {
		
		//return scoreDAO.getList();
//		String str = null;
//		str.charAt(0);
		return scoreMapper.getList();
	}
	
	@Override
	public void delete(int sno) {
		//scoreDAO.delete(sno);
		scoreMapper.delete(sno);
	}
	
}
