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
     * @return sorted commets
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
     *            complete blog response
     * @param commentsJson
     *            complete comment response
     * @return updated blog response
     */
    public BlogResponseVO getBlogs(JSONObject blogsJson, JSONObject commentsJson) {
        BlogResponseVO blogsresponse = (BlogResponseVO) JsonUtil.convertJsonToJavaObject(blogsJson.toString(),
                BlogResponseVO.class);

        List<BlogDetailsVO> blogs = blogsresponse.getBlogsList();
        // populating comment details for each blog
        if (null != blogs && !blogs.isEmpty()) {

            blogs.forEach(blog -> {
                List<String> commentIdList = blog.getComments();
                if (null != commentIdList && !commentIdList.isEmpty()) {
                    List<CommentDetailsVO> commentDetailsList = new ArrayList<>();

                    // Add each comment details in blog
                    commentIdList.forEach(commentId -> {
                        commentDetailsList.add(getCommentDetail(commentsJson, commentId));
                    });

                    blog.setCommentsList(commentDetailsList);
                }
            });
        }
        // sort the blog by blog Description
        Collections.sort(blogsresponse.getBlogsList(),
                (firstBlog, secondBlog) -> firstBlog.getBlogName().compareTo(secondBlog.getBlogName()));
        return blogsresponse;
    }

    /**
     * This method fetches comment details for given comment id from comment
     * response and returns it.
     * 
     * @param commentsJson
     *            complete comment response.
     * @param commentId
     *            comment id for which comment details needs to be fetched.
     * @return comment detail
     */
    private CommentDetailsVO getCommentDetail(JSONObject commentsJson, String commentId) {
        CommentResponseVO commentresponse = (CommentResponseVO) JsonUtil
                .convertJsonToJavaObject(commentsJson.toString(), CommentResponseVO.class);

        return commentresponse.getCommentsList().stream().filter(comment -> commentId.equals(comment.getCommentId()))
                .findAny().orElse(null);

    }
}
