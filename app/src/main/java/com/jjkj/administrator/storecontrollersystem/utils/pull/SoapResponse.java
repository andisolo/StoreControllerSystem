package com.jjkj.administrator.storecontrollersystem.utils.pull;


import com.jjkj.administrator.storecontrollersystem.exception.DataRequestFailedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String toMessage() throws DataRequestFailedException {
        String result = this.getResult();
        String group = "";
        Pattern pattern = Pattern.compile(MESSAGE);
        Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
            group = matcher.group(1);
        }
        if (!result.contains(SUCCEED)) {
            throw new DataRequestFailedException(group);
        }
        return group;
    }
}
