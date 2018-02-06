package com.exercise.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.json.simple.JSONObject;

import com.exercise.util.JsonUtil;
import com.exercise.vo.BlogDetailsVO;
import com.exercise.vo.BlogResponseVO;
import com.exercise.vo.CommentDetailsVO;
import com.exercise.vo.CommentResponseVO;

/**
 * This is the helper class to do data massing of response
 * 
 * @author rshiv2
 *
 */
@Component(immediate = true, name = "helper Service")
@Service(Helper.class)
public class Helper {

	/**
	 * This method sorts the comments by comment description
	 * 
	 * @param response
	 * @return
	 */
	public CommentResponseVO sortComments(JSONObject response) {
		CommentResponseVO commentresponse = (CommentResponseVO) JsonUtil.convertJsonToJavaObject(response.toString(),

				CommentResponseVO.class);
		Collections.sort(commentresponse.getCommentsList(),
				(firstComment, secondComment) -> firstComment.getComment().compareTo(secondComment.getComment()));
		return commentresponse;
	}

	/**
	 * This methods populates the comment details for each blogs.
	 * 
	 * @param blogsJson
	 * @param commentsJson
	 * @return
	 */
	public BlogResponseVO getBlogs(JSONObject blogsJson, JSONObject commentsJson) {
		BlogResponseVO blogsresponse = (BlogResponseVO) JsonUtil.convertJsonToJavaObject(blogsJson.toString(),
				BlogResponseVO.class);
		CommentResponseVO commentresponse = (CommentResponseVO) JsonUtil
				.convertJsonToJavaObject(commentsJson.toString(), CommentResponseVO.class);

		List<BlogDetailsVO> blogs = blogsresponse.getBlogsList();
		// populating comment details for each blog
		if (null != blogs && !blogs.isEmpty()) {
			blogs.forEach(blog -> {
				List<CommentDetailsVO> commentDetailsList = new ArrayList<>();
				List<String> commentIdList = blog.getComments();
				// for each comment id in the blog fetch comment details and
				// populate comment details
				commentIdList.forEach(commentId -> {
					CommentDetailsVO commentDetail = commentresponse.getCommentsList().stream()
							.filter(comment -> commentId.equals(comment.getCommentId())).findAny().orElse(null);
					commentDetailsList.add(commentDetail);

				});

				blog.setCommentsList(commentDetailsList);

			});
		}
		// sort the blog by blog Description
		Collections.sort(blogsresponse.getBlogsList(),
				(firstBlog, secondBlog) -> firstBlog.getBlogName().compareTo(secondBlog.getBlogName()));
		return blogsresponse;
	}
}
