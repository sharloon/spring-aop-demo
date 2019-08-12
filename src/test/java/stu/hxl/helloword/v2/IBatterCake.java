package stu.hxl.helloword.v2;

/**
 * 展示煎饼的详情和总价格
 * @author sharloon
 * @date 2019/7/16
 */
public interface IBatterCake {

    /**
     * 获取详情
     * @return
     */
    String getMsg();

    /**
     * 获取总价
     * @return
     */
    Integer getPrice();

}
