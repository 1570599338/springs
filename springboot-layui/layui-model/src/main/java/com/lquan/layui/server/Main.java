package com.lquan.layui.server;

/**
 * @ClassName: Main
 * @Package: com. study.server
 * @Description:
 * @Datetime: 2020/11/20   15:02
 * @author:  zhou
 */
public class Main {
    public static void main(String[] args)throws Exception {
        Server server = new Server();
        server.copyTo();
        System.out.println(server.toString());
    }
}
