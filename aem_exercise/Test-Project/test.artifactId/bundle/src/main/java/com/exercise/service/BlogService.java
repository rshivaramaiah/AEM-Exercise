package com.exercise.service;

import com.exercise.vo.BlogResponseVO;
import com.exercise.vo.CommentResponseVO;
/**Service for fetching blogs
 * @author rshiv2
 *
 */
public interface BlogService {
	
	/** This fetches comments in sorted order.
	 * @return
	 */
	public CommentResponseVO getComments();
	
	/**This method provides blogs with comments.
	 * @return
	 */
	public BlogResponseVO getBlogs();

}
