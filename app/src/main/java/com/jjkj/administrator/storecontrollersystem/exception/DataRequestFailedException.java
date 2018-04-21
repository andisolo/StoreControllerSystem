package com.jjkj.administrator.storecontrollersystem.exception;

import java.io.IOException;

/**
 * @author Administrator
 * @date 2018/3/21
 */

public class DataRequestFailedException extends IOException {
    public DataRequestFailedException(String message) {
        super(message);
    }
}
