package com.board.workspace;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.workspace.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "Board";

	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create",vo); 
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}
	
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete",bno); 
	}

	@Override

	public List<BoardVO> listAll() throws Exception {

		return session.selectList(namespace + ".listAll");

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read",bno);
	}

	@Override
	public void viewCount(Integer bno) throws Exception {
		session.update(namespace + ".update", bno); 
		
	}


}
