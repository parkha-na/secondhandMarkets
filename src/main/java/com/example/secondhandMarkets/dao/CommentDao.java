package com.example.secondhandMarkets.dao;

import com.example.secondhandMarkets.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
	List<CommentVo> commentList(CommentVo vo);
	void insertComments(CommentVo vo);
	int commentCount(CommentVo vo);
	void deleteComments(CommentVo vo);
}
