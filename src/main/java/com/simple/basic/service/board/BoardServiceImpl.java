package com.simple.basic.service.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.BoardDTO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
		
	@Override
	public ArrayList<BoardDTO> getList() {
		return boardMapper.getList();
	}
	@Override
	public void regist(BoardDTO boardDTO) {
		boardMapper.regist(boardDTO);	
	}
	@Override
	public void delete(int num) {
		boardMapper.delete(num);
	}
	@Override
	public BoardDTO getContent(int num) {
		return boardMapper.getContent(num);
	}
	@Override
	public void update(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
	}
}
