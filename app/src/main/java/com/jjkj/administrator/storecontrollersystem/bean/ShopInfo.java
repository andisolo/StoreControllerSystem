package com.jjkj.administrator.storecontrollersystem.bean;

/**
 * @author Administrator
 */

public enum ShopInfo {
    /**
     * 用户名和密码
     */
    SUPER("001", "regent");
    public String username;
    public String password;

    ShopInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
