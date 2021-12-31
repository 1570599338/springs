package com.lquan.layui.controller;

import com.lquan.layui.dto.resp.ResultVO;
import com.lquan.layui.server.Server;
import com.lquan.layui.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ServerController
 * @Package: com.kaishun.study.controller
 * @Description:
 * @Datetime: 2020/11/20   15:19
 * @author: kaishun.zhou
 */
@RestController
@RequestMapping("server")
public class ServerController {

    @GetMapping("get")
    public ResultVO get() throws Exception{
        Server server = new Server();
        server.copyTo();
        System.out.println(server.toString());
        return ResultVOUtil.success(server);
    }

}
