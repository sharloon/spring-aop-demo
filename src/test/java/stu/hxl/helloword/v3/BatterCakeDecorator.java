package stu.hxl.helloword.v3;

import lombok.Data;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public abstract class BatterCakeDecorator implements IBatterCake {

    private IBatterCake batterCake;

    public BatterCakeDecorator(IBatterCake batterCake) {
        this.batterCake = batterCake;
    }

    @Override
    public String getMsg() {
        return this.batterCake.getMsg();
    }

    @Override
    public Integer getPrice() {
        return this.batterCake.getPrice();
    }
}
