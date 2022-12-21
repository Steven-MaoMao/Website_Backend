package com.Website.Website_Backend.Controller;

import com.Website.Website_Backend.Model.MessageComment;
import com.Website.Website_Backend.Model.Result;
import com.Website.Website_Backend.Service.MessageCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/messagecomment")
public class MessageCommentController {
    @Autowired
    private MessageCommentService messageCommentService;

    // 添加一条评论
    @PostMapping("/set")
    public Result setMessageComment(@RequestBody MessageComment comment) throws IOException {
        Result result = new Result();
        result.setFlag(messageCommentService.insert(comment.getName(), comment.getComment(), comment.getParent()));
        return result;
    }
}
