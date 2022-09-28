package com.msh.furn.util;

public class Result<T> {
    private String code;//狀態碼
    private String msg;//狀態說明
    private T data;//攜帶數據

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    //編寫方法返回需要的Result對象-成功的Result
    public static Result success(){
        Result<Object> result = new Result<>();
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
    //編寫方法返回需要的Result對象-成功的Result，同時可以攜帶數據
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(data);
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    //編寫方法返回需要的Result對象-失敗的Result
    public static Result error(String code,String msg){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    //編寫方法返回需要的Result對象-成功的Result，同時可以攜帶數據
    public static <T> Result<T> error(String code,String msg,T data){
        Result<T> result = new Result<>(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
