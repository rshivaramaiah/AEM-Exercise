package com.exercise.sightly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.exercise.service.BlogService;
import com.exercise.vo.BlogResponseVO;
import com.exercise.vo.CommentResponseVO;

/**
 * This is the sightly class for Blog component. This on activations fetches
 * blogs and comments from backend services. And merges them in single list and
 * sends.
 * 
 * @author rshiv2
 *
 */
public class BlogSightly extends WCMUsePojo {

	public static final Logger LOG = LoggerFactory.getLogger(BlogSightly.class);

	private String sampleText;

	private CommentResponseVO comments;

	private BlogResponseVO blogs;

	public String getSampleText() {
		return sampleText;
	}

	public void setSampleText(String sampleText) {
		this.sampleText = sampleText;
	}

	public CommentResponseVO getComments() {
		return comments;
	}

	public void setComments(CommentResponseVO comments) {
		this.comments = comments;
	}

	public BlogResponseVO getBlogs() {
		return blogs;
	}

	public void setBlogs(BlogResponseVO blogs) {
		this.blogs = blogs;
	}

	/**
	 * This is the activate method, it fetches blogs with comment on activation.
	 */
	@Override
	public void activate() throws Exception {
		LOG.debug("Inside activate method");
		BlogService blogService = getSlingScriptHelper().getService(BlogService.class);
		comments = blogService.getComments();
		blogs = blogService.getBlogs();
		LOG.debug("Activation completed");

	}

}
