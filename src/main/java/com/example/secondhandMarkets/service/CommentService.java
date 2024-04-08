package com.example.secondhandMarkets.service;

import com.example.secondhandMarkets.vo.CommentVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
	List<CommentVo> commentList(CommentVo vo);
	void insertComments(CommentVo vo);
	int commentCount(CommentVo vo);
	void deleteComments(CommentVo vo);
}
