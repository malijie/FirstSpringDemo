package springboot.test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.test.entity.Result;
import springboot.test.enums.ResultEnum;


public class MobileException extends RuntimeException{
    private Integer code;
    private String msg;

    public MobileException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "MobileException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
