package com.topblog.myblog.util;

import com.topblog.myblog.model.vo.ResponseMsg;

/**
 * @Author: RETURN
 * @Date: 2020/3/31 23:08
 */
public class ResultUtil {

    public static ResponseMsg success(){
        return new ResponseMsg<>(200,"成功",null);
    }
    public static ResponseMsg success(String msg){
        return new ResponseMsg<>(200,msg,null);
    }
    public static ResponseMsg<Object> success(Object data){
        return new ResponseMsg<>(200,"成功",data);
    }
    public static ResponseMsg<Object> success(String msg,Object data){
        return new ResponseMsg<>(200,msg,data);
    }

    public static ResponseMsg clientError(String msg){
        return new ResponseMsg<>(400,msg,null);
    }
    public static ResponseMsg serverError(String msg){
        return new ResponseMsg<>(500,msg,null);
    }
}
