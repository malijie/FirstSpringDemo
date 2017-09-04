package springboot.test.entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Mobile {

    @Id
    @GeneratedValue
    private int id;

    private String band;

    @Min(value = 5,message = "品牌价值不能小于前五")
    private Integer rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", band='" + band + '\'' +
                ", rate=" + rate +
                '}';
    }
}
