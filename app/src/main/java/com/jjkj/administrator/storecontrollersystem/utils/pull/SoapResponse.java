package com.jjkj.administrator.storecontrollersystem.utils.pull;


/**
 * @author Administrator
 */

public class SoapResponse {
    private static final String SUCCEED = "<code>1</code>";
    private static final String MESSAGE = "<message>([\\s\\S]*)</message>";

    private String result;

    public String getResult() {
        return result;
    }

    @SuppressWarnings("unused")
    public void setResult(String result) {
        this.result = result;
    }
}
