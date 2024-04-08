package com.example.secondhandMarkets.dao;

import com.example.secondhandMarkets.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
	void insert(UserVo vo);
	UserVo login(UserVo vo);
}
