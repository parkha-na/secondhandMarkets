package com.example.secondhandMarkets.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {
	private String sno;
	private String postId;
	private String comments;
	private String writer;
	private char deleteYn;
	private Date createDate;
	private Date modifyDate;
}
