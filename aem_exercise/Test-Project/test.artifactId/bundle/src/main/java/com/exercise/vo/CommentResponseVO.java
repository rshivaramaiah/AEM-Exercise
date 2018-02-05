package com.exercise.vo;

import java.util.List;

public class CommentResponseVO {

    private List<CommentDetailsVO> commentsList;

    public List<CommentDetailsVO> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<CommentDetailsVO> commentsList) {
        this.commentsList = commentsList;
    }

}
