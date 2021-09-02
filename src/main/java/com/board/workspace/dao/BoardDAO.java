package com.board.workspace.dao;

import java.util.List;

import com.board.workspace.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(Integer bno) throws Exception; 
	public List<BoardVO> listAll() throws Exception; 
	public BoardVO read(Integer bno) throws Exception; 
}