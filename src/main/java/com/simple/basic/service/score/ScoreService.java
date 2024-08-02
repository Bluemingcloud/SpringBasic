package com.simple.basic.service.score;

import java.util.ArrayList;

import com.simple.basic.command.ScoreVO;

public interface ScoreService {
	
	public void regist(ScoreVO vo);
	
	public ArrayList<ScoreVO> getList();

}
