package com.github.wongoo.dubbo.hello;

import java.io.Serializable;

/**
 * @author wongoo
 */
public class Response implements Serializable {
    private long requestId;
    private String result;

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
