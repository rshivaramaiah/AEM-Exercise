package com.exercise.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentResponseVO {

	@JsonProperty("commentsList")
	private List<CommentDetailsVO> commentsList;

	public List<CommentDetailsVO> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<CommentDetailsVO> commentsList) {
		this.commentsList = commentsList;
	}

}
