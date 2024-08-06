package com.simple.basic.service.score;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.ScoreVO;

@Mapper // Mapper 임을 나타냄
public interface ScoreMapper {
	
	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList();
	public void delete(int sno);
		
}
