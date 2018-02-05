package com.exercise.serviceImpl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.json.simple.JSONObject;

import com.exercise.client.HttpClient;
import com.exercise.helper.Helper;
import com.exercise.service.BlogService;
import com.exercise.vo.CommentResponseVO;
@Component(immediate = true, name = "Blog Service")
@Service(BlogService.class)
public class BlogServiceImpl implements BlogService{
	
	@Reference
	HttpClient httpClient;
	
	@Reference
	Helper helper;
	
	@Override
	public CommentResponseVO getComments(){
		JSONObject responseJson = httpClient.executeGet("http://localhost:8091/MockServices/mock/comments");
		return helper.sortComments(responseJson);
	}

}
