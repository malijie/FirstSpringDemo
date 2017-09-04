package springboot.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.test.enums.ResultEnum;
import springboot.test.exception.MobileException;
import springboot.test.reponsitory.MobileRepository;
import springboot.test.entity.Mobile;

@Service
public class MobileService {

    @Autowired
    private MobileRepository mobileRepository;

    public void insertTwoMobile(){
        Mobile b1 = new Mobile();
        b1.setId(9);
        b1.setBand("meizu");
        mobileRepository.save(b1);

        Mobile b2 = new Mobile();
        b2.setId(10);
        b2.setBand("xiaomiXIXIXIXIXIXIXIXIIXIXIXIXX");
        mobileRepository.save(b2);
    }

    public Integer getRate(Integer id) throws Exception {
        Mobile mobile = mobileRepository.findOne(id);
        int rate = mobile.getRate();
        if(rate<5){
            throw new MobileException(ResultEnum.RATE_BELOW_5);
        }else if(rate>=5 && rate<10){
            throw new MobileException(ResultEnum.RATE_BELOW_10);

        }
        return rate;
    }
}
