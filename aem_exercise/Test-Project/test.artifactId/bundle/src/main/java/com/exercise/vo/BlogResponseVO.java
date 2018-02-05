package com.exercise.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogResponseVO {
	
	@JsonProperty("blogsList")
	private List<BlogDetailsVO> blogsList;

	public List<BlogDetailsVO> getBlogsList() {
		return blogsList;
	}

	public void setBlogsList(List<BlogDetailsVO> blogsList) {
		this.blogsList = blogsList;
	}

	
}
