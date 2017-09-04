package springboot.test.controller;

import springboot.test.property.MobileProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private MobileProperty mobile;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "id",defaultValue = "0",required = false) Integer myId){
        return "Hello Spring Boot id=" + myId;
    }

}
