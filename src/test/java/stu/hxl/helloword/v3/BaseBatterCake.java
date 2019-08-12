package stu.hxl.helloword.v3;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public class BaseBatterCake implements IBatterCake{
    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public Integer getPrice() {
        return 5;
    }
}
