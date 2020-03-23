package com.myboard.mapper;

import java.util.List;

import com.myboard.vo.CommentVO;

public interface CommentMapper {
//	´ñ±Û Ãß°¡
	public void commentInsert(CommentVO comment);
//	´ñ±Û ¸®½ºÆ®
	public List<CommentVO> commentList(int bnum);
//	´ñ±Û »èÁ¦
	public void commentDelete(int num);
//	°Ô½Ã±Û »èÁ¦½Ã ´ñ±Û »èÁ¦ 
	public void allCommentDelete(int bnum);
}
