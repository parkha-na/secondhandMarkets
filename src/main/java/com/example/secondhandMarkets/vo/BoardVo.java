package com.example.secondhandMarkets.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVo {
	private String sno;
	private String sname;
	private String title;
	private String ch1;
	private String ch2;
	private String contents;
	private Date modifyDate;
}
