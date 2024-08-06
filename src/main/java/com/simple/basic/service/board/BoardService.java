package com.simple.basic.service.board;

import java.util.ArrayList;

import com.simple.basic.command.BoardDTO;

public interface BoardService {
	
	public ArrayList<BoardDTO> getList();
	public void regist(BoardDTO boardDTO);
	public void delete(int num);
	public BoardDTO getContent(int num); 
	public void update(BoardDTO boardDTO);
}
