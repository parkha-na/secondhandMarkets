package com.example.secondhandMarkets.service;

import com.example.secondhandMarkets.vo.BoardVo;
import com.example.secondhandMarkets.vo.ImageVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
	   List<BoardVo> select(BoardVo vo);
	   BoardVo content(BoardVo vo);
	   BoardVo form(BoardVo vo);
	   void insert(BoardVo vo);
	   void update(BoardVo vo);
	   void delete(BoardVo vo);
	   void insertImage(String data);
	   List<ImageVo> selectImage(ImageVo iVo);
	   void updateImage(String data);
}