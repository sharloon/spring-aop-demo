package stu.hxl.helloword.v2;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public abstract class AbstractBatterCake implements IBatterCake {

    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public Integer getPrice() {
        return 5;
    }

}
