package com.exercise.sightly;

import javax.jcr.RepositoryException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.exercise.service.BlogService;
import com.exercise.vo.BlogResponseVO;
import com.exercise.vo.CommentResponseVO;
import com.test.MockWCMUseBase;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;

/**
 * The Class GetConfigValueTest.
 * 
 * @author Sapient
 */
@RunWith(JMockit.class)
public class BlogSightlyTest extends MockWCMUseBase {

	@Mocked
	private JSONObject json;

	@Mocked
	private BlogService blogService;
	@Mocked
	CommentResponseVO comments;
	@Mocked
	BlogResponseVO blogs;

	private BlogSightly sampleSightly;

	/** The request. */
	@Mocked
	private SlingHttpServletRequest request;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alcs.web.component.MockWCMUseBase#init()
	 */
	@Before
	public void init() {
		super.init();
		sampleSightly = new BlogSightly();
	}

	/**
	 * Sets the expectations.
	 *
	 * @throws RepositoryException
	 *             the repository exception
	 * @throws JSONException
	 *             the JSON exception
	 */
	private void setExpectations() throws RepositoryException, JSONException {
		new NonStrictExpectations() {
			{
				resource.getResourceResolver();
				returns(resourceResolver);

			}
		};

	}

	@Test
	public void testActivatae() throws Exception {
		new NonStrictExpectations() {
			{
				resource.getResourceResolver();
				returns(resourceResolver);
				slingScriptHelper.getService(BlogService.class);
				returns(blogService);
				blogService.getComments();
				returns(comments);
				blogService.getBlogs();
                returns(blogs);
			}
		};
		sampleSightly.activate();

	}
}
