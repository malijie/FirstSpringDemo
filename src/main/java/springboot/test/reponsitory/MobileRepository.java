package springboot.test.reponsitory;

import springboot.test.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileRepository extends JpaRepository<Mobile,Integer>{
    List<Mobile> findMobileByBand(String band);
}
