package springboot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springboot.test.entity.Mobile;
import springboot.test.entity.Result;
import springboot.test.enums.ResultEnum;
import springboot.test.reponsitory.MobileRepository;
import springboot.test.service.MobileService;
import springboot.test.utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MobileController {

    @Autowired
    private MobileRepository mobileRepository;
    @Autowired
    private MobileService service;

    @RequestMapping(value = "/mobile",method = RequestMethod.GET)
    public List<Mobile> getMobiles(){
        return mobileRepository.findAll();
    }

    @GetMapping(value = "/mobile/{id}")
    public Mobile getMobileById(@PathVariable(value = "id") Integer id){
        return mobileRepository.findOne(id);
    }

    @PostMapping(value = "/mobile/save")
    public Result<Mobile> saveOneMobile(@Valid Mobile mobile, BindingResult result){
        if(result.hasErrors()){
            return ResultUtil.error(ResultEnum.RATE_BELOW_5.getCode(),ResultEnum.RATE_BELOW_5.getMsg());
        }
        mobileRepository.save(mobile);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

    @PutMapping(value = "mobile/update/{id}")
    public void updateMobileInfo(@PathVariable(value = "id") int id,
                                 @RequestParam(value = "band") String band){
        Mobile b = new Mobile();
        b.setId(id);
        b.setBand(band);
        mobileRepository.save(b);
    }

    @DeleteMapping(value = "mobile/delete/{id}")
    public void deleteOneMobile(@PathVariable(value = "id") int id){
        mobileRepository.delete(id);
    }

    @RequestMapping(value = "mobile/band/{band}")
    public List<Mobile> findMobileByBand(@PathVariable(value = "band") String band){
        return mobileRepository.findMobileByBand(band);
    }

    @PostMapping(value = "mobile/two")
    @Transactional
    public void insertTwo(){
        service.insertTwoMobile();
    }

    @RequestMapping(value = "mobile/getRate/{id}")
    public int getRate(@PathVariable(value = "id") Integer id) throws Exception {
        return service.getRate(id);
    }

}
