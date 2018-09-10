package com.lm.po;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 龙鸣 on 2017/8/25.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class JsonMessage {

    //100表示成功 200表示失败
    private String code;

    //提示信息
    private String message;

    //用户要返回给浏览器中的数据
    public Map<String,Object> userContent=new HashMap<String,Object>();

    public static JsonMessage success(){
        JsonMessage jsonMessage=new JsonMessage();
        jsonMessage.setCode("100");
        jsonMessage.setMessage("处理成功！");
        return jsonMessage;
    }

    public static JsonMessage fail(){
        JsonMessage jsonMessage=new JsonMessage();
        jsonMessage.setCode("200");
        jsonMessage.setMessage("处理失败！");
        return jsonMessage;
    }

    public JsonMessage add(String key, Object value){
        this.getUserContent().put(key,value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getUserContent() {
        return userContent;
    }

    public void setUserContent(Map<String, Object> userContent) {
        this.userContent = userContent;
    }
}
