package com.exercise.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogDetailsVO {
	@JsonProperty("blogId")
	private String blogId;

	@JsonProperty("blogDescription")
	private String blogDescription;

	@JsonProperty("blogName")
	private String blogName;

	@JsonProperty("comments")
	private List<String> comments;

	@JsonIgnore
	private List<CommentDetailsVO> commentsList;

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<CommentDetailsVO> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<CommentDetailsVO> commentsList) {
		this.commentsList = commentsList;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

}
