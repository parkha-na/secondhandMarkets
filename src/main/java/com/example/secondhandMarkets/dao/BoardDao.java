package com.example.secondhandMarkets.dao;

import com.example.secondhandMarkets.vo.BoardVo;
import com.example.secondhandMarkets.vo.ImageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
   List<BoardVo> select(BoardVo vo);
   BoardVo content(BoardVo vo);
   void insert(BoardVo vo);
   void update(BoardVo vo);
   void delete(BoardVo vo);
   BoardVo form(BoardVo vo);
   void insertImage(String data);
   List<ImageVo> selectImage(ImageVo iVo);
   void updateImage(String data);
}