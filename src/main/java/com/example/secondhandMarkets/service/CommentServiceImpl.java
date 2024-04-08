package com.example.secondhandMarkets.service;

import com.example.secondhandMarkets.dao.CommentDao;
import com.example.secondhandMarkets.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao dao;
	
	@Override
	public List<CommentVo> commentList(CommentVo vo) {
		// TODO Auto-generated method stub
		return dao.commentList(vo);
	}

	@Override
	public void insertComments(CommentVo vo) {
		dao.insertComments(vo);
		
	}

	@Override
	public int commentCount(CommentVo vo) {
		// TODO Auto-generated method stub
		return dao.commentCount(vo);
	}

	@Override
	public void deleteComments(CommentVo vo) {
		dao.deleteComments(vo);
	}
	
}
