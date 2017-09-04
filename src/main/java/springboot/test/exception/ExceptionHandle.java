package springboot.test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.test.entity.Result;
import springboot.test.enums.ResultEnum;
import springboot.test.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> handle(Exception e){
        System.out.println("handle e=" + e);
        if(e instanceof MobileException){
            MobileException e2 = (MobileException)e;
            return ResultUtil.error(e2.getCode(),e2.getMessage());
        }else{
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }

    }

}
