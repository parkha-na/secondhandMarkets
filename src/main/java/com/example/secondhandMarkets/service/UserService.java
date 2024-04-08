package com.example.secondhandMarkets.service;

import com.example.secondhandMarkets.vo.UserVo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	void insert(UserVo vo);
	UserVo login(UserVo vo);
	
}
