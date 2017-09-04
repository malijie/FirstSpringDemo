package springboot.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import springboot.test.entity.Mobile;
import springboot.test.entity.Result;
import springboot.test.enums.ResultEnum;

public class ResultUtil {


    public static Result success(Object object){
        Result<Object> mobileResult = new Result();
        mobileResult.setCode(ResultEnum.SUCCESS.getCode());
        mobileResult.setMsg(ResultEnum.SUCCESS.getMsg());
        mobileResult.setData(object);
        return mobileResult;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result mobileResult = new Result();
        mobileResult.setCode(code);
        mobileResult.setMsg(msg);
        return mobileResult;
    }

}
