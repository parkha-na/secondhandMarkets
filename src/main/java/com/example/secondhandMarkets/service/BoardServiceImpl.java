package com.example.secondhandMarkets.service;

import com.example.secondhandMarkets.dao.BoardDao;
import com.example.secondhandMarkets.vo.BoardVo;
import com.example.secondhandMarkets.vo.ImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardVo> select(BoardVo vo) {
		return dao.select(vo);
	}

	@Override
	public BoardVo content(BoardVo vo) {
		// TODO Auto-generated method stub
		return dao.content(vo);
	}

	@Override
	public void insert(BoardVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(BoardVo vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(BoardVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public void insertImage(String data) {
		dao.insertImage(data);
	}

	@Override
	public List<ImageVo> selectImage(ImageVo iVo) {
		return dao.selectImage(iVo);
	}

	@Override
	public void updateImage(String data) {
		dao.updateImage(data);
	}

	@Override
	public BoardVo form(BoardVo vo) {
		// TODO Auto-generated method stub
		return dao.form(vo);
	}


}
