package com.simple.basic.service.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.BoardDTO;

@Mapper
public interface BoardMapper {
	
	public ArrayList<BoardDTO> getList();
	public void regist(BoardDTO boardDTO);
	public void delete(int num);
	public BoardDTO getContent(int num);
	public void update(BoardDTO boardDTO);
}
