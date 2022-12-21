package com.Website.Website_Backend.Controller;

import com.Website.Website_Backend.Model.Data;
import com.Website.Website_Backend.Model.MessageBoard;
import com.Website.Website_Backend.Model.Result;
import com.Website.Website_Backend.Service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/messageboard")
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;

    // 查询某一页的留言
    @GetMapping("/get/{page}")
    public Result getMessageBoard(@PathVariable int page) throws IOException {
        List<Data> dataList = messageBoardService.selectByPage(page);
        int count = messageBoardService.selectCount();
        Result result = new Result();
        if (dataList != null && count != -1) {
            result.setFlag(true);
            result.setData(dataList);
            result.setCount(count);
        }
        return result;
    }

    // 添加一条留言
    @PostMapping("/set")
    public Result setMessageBoard(@RequestBody MessageBoard message) throws IOException {
        Result result = new Result();
        result.setFlag(messageBoardService.insert(message.getName(), message.getMessage()));
        return result;
    }
}
