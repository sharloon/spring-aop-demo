package stu.hxl.helloword.v2;

import lombok.Data;

/**
 * @author sharloon
 * @date 2019/7/16
 */
@Data
public class BatterCakeWithEgg extends AbstractBatterCake {

    private Integer num;

    public BatterCakeWithEgg(Integer num) {
        this.num = num;
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+" + this.getNum() + "个鸡蛋";
    }

    @Override
    public Integer getPrice() {
        return super.getPrice() + this.getNum();
    }
}
