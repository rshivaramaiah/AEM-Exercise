package com.exercise.serviceImpl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exercise.client.HttpClient;
import com.exercise.constants.Constants;
import com.exercise.helper.Helper;
import com.exercise.service.BlogService;
import com.exercise.vo.BlogResponseVO;
import com.exercise.vo.CommentResponseVO;

/**This is the implementation class for BlogService.
 * @author rshiv2
 *
 */


@Component(immediate = true, name = "Blog Service")
@Service(BlogService.class)
public class BlogServiceImpl implements BlogService {

	@Reference
	HttpClient httpClient;

	@Reference
	Helper helper;

	public static final Logger LOG = LoggerFactory.getLogger(BlogServiceImpl.class);

	@Override
	public CommentResponseVO getComments() {
		JSONObject responseJson = httpClient.executeGet(Constants.URL_GET_COMMENTS);
		return helper.sortComments(responseJson);
	}
	
	/**
	 * This method provides list of blogs with comments.
	 */
	@Override
	public BlogResponseVO getBlogs() {
		JSONObject commentsJson = httpClient.executeGet(Constants.URL_GET_COMMENTS);
		JSONObject blogsJson = httpClient.executeGet(Constants.URL_GET_BLOGS);
		return helper.getBlogs(blogsJson, commentsJson);
	}

}
