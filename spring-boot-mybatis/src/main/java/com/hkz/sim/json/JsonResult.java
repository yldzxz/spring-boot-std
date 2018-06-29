package com.hkz.sim.json;

/**
 * Created by huangkz on 2018/6/25.
 */
public class JsonResult {
    private String status;
    private Object object;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }
}
