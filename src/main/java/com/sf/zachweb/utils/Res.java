package com.sf.zachweb.utils;
import lombok.Data;

/**
 * @ClassName Res
 * @Description
 * @Author 01371059
 * @Date 2018/10/3 下午11:57
 * @Version 1.0
 **/
@Data
public class Res<T> {
    private String succ;
    private String msg;
    private T result;
    private String detail;
    public Res() {}
    public static Res buildOk(){
        Res res = new Res();
        res.setSucc("ok");
        return res;
    }
    public static Res buildOk(String msg){
        Res res = new Res();
        res.setSucc("ok");
        res.setMsg(msg);
        return res;
    }
    public static Res buildOk(Object result){
        Res res = new Res();
        res.setSucc("ok");
        res.setResult(result);
        return res;
    }
    public static Res buildFail(String msg) {
        Res res = new Res();
        res.setSucc("fail");
        res.setMsg(msg);
        return res;
    }

}
