package com.exercise.helper;

import java.util.Collections;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.json.simple.JSONObject;

import com.exercise.util.JsonUtil;
import com.exercise.vo.CommentResponseVO;

@Component(immediate = true, name = "helper Service")
@Service(Helper.class)
public class Helper {

    public CommentResponseVO sortComments(JSONObject response) {
        CommentResponseVO commentresponse = (CommentResponseVO) JsonUtil.convertJsonToJavaObject(response.toString(),
                CommentResponseVO.class);
        Collections.sort(commentresponse.getCommentsList(), (p1, p2) ->p1.getComment().compareTo(p2.getComment()));
        return commentresponse;
    }
}
