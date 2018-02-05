package com.exercise.sightly;

import com.adobe.cq.sightly.WCMUsePojo;
import com.exercise.service.BlogService;
import com.exercise.vo.CommentResponseVO;

public class BlogSightly extends WCMUsePojo {

    private String sampleText;

    private CommentResponseVO comments;

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

    @Override
    public void activate() throws Exception {
        BlogService blogService = getSlingScriptHelper().getService(BlogService.class);
        comments = blogService.getComments();

    }

}
