package com.cason.cos.entity.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 14:43
 */

@Data
public class Resp {
    private Integer code;

    private String message;

    private Date timestamp = new Date();

    private Object data;

    public static Resp success(Object data) {
        Resp resp = new Resp();
        resp.setData(data);
        resp.setTimestamp(new Date());
        resp.setCode(HttpStatus.OK.value());
        resp.setMessage("操作成功");
        return resp;
    }
    public static Resp fail(Object data) {
        Resp resp = new Resp();
        resp.setData(data);
        resp.setTimestamp(new Date());
        resp.setCode(HttpStatus.SERVICE_UNAVAILABLE.value());
        resp.setMessage("操作失败");
        return resp;
    }
    public static Resp success() {
        Resp resp = new Resp();
        resp.setData(null);
        resp.setTimestamp(new Date());
        resp.setCode(HttpStatus.OK.value());
        resp.setMessage("操作成功");
        return resp;
    }
    public static Resp defaultSuccess(String msg) {
        Resp resp = new Resp();
        resp.setData(null);
        resp.setTimestamp(new Date());
        resp.setCode(HttpStatus.OK.value());
        resp.setMessage(msg);
        return resp;
    }
}

