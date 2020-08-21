package com.github.wongoo.dubbo.hello;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wongoo
 */
public class Request implements Serializable {
    private long id;
    private String content;
    private Date time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
