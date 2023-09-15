package com.ssafy.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.member.model.dao.MemberDaoImpl;
import com.ssafy.util.DBUtil;

public class BoardServiceImpl implements BoardService {
	
	private static BoardService boardService = new BoardServiceImpl();
	
	private BoardServiceImpl() {
		
	}
	
	public static BoardService getBoardService() {
		return boardService;
	}

	@Override
	public void registerArticle(BoardDto boardDto) {
		BoardDaoImpl.getBoardDao().registerArticle(boardDto);
	}

	@Override
	public List<BoardDto> searchListAll() {
		return BoardDaoImpl.getBoardDao().searchListAll();
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		return BoardDaoImpl.getBoardDao().searchListBySubject(subject);
	}

	@Override
	public BoardDto viewArticle(int no) {
		return BoardDaoImpl.getBoardDao().viewArticle(no);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		BoardDaoImpl.getBoardDao().modifyArticle(boardDto);
	}

	@Override
	public void deleteArticle(int no) {
		BoardDaoImpl.getBoardDao().deleteArticle(no);
	}

}
