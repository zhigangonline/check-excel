package com.use.vo;

public class ResultVO<T>{
    private Integer status;
    private String message;
    private T datas;


    public ResultVO(Integer status, String message, T datas) {
        this.status = status;
        this.message = message;
        this.datas = datas;
    }

    public ResultVO(ResultEnum resultEnum, T datas) {
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
        this.datas = datas;
    }

    public ResultVO(ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
        this.datas = (T) resultEnum.getDatas();
    }
    public ResultVO(ResultEnum resultEnum,String ...args) {
        this.status = resultEnum.getStatus();
        this.message =  String.format(resultEnum.getMessage(), args);
        this.datas = null;
    }
}
