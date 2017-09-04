package springboot.test.enums;

public enum ResultEnum {

    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"请求成功，哈哈哈"),
    RATE_BELOW_5(101,"品牌排名小于5"),
    RATE_BELOW_10(101,"品牌排名大于5，小于10");

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
