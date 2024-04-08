package com.example.secondhandMarkets.service;


import com.example.secondhandMarkets.dao.UserDao;
import com.example.secondhandMarkets.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	@Override
	public void insert(UserVo vo) {
		dao.insert(vo);
	}
	
	@Override
	public UserVo login(UserVo vo) {
		return dao.login(vo);
	}
}
