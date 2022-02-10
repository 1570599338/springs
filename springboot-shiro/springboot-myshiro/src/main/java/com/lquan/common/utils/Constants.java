package com.lquan.common.utils;

/**
 * 通用常量信息
 *
 * @author
 */
public class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    // 初始默认密码
    public static final String PASSWORD = "123456";

    // 文件路径
    public static final String profile = "D:/lquan/uploadPath";

    // 获取头像上传路径
   // public static final String avatarPath = "D:/lquan/uploadPath/avatar";
    public static final String avatarPath = profile+"/avatar";

    // 获取下载路径
  //  public static final String downloadPath = "D:/lquan/uploadPath/download";
    public static final String downloadPath = profile+"download";


    // 获取上传路径
  //  public static final String uploadPath = "D:/lquan/uploadPath/upload";
    public static final String uploadPath = profile+"/upload";


}
