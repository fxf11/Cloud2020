package com.fxf.springcloud.alibaba.handler;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/23 22:19
 */
@Data
@NoArgsConstructor
public class ResultBean {
    private int code;
    private String devMsg;
    private String msg;
    private String data;

    public ResultBean(int code, String devMsg, String msg, String data) {
        this.code = code;
        this.devMsg = devMsg;
        this.msg = msg;
        this.data = data;
    }
    public ResultBean(int code, String devMsg, String msg) {
        this.code = code;
        this.devMsg = devMsg;
        this.msg = msg;
        this.data = "";
    }

    public String getResult() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("devMsg",devMsg);
        jsonObject.put("msg",msg);
        jsonObject.put("data",data);
        return jsonObject.toString();
    }
}
