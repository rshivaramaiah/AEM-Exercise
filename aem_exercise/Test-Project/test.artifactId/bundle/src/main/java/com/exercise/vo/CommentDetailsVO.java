package com.exercise.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentDetailsVO {
	@JsonProperty("commentId")
	private String commentId;

	@JsonProperty("comment")
	private String comment;

	@JsonProperty("commenterName")
	private String commenterName;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

}
