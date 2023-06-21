package com.example.demo.constant;

/**
 * 全局常量
 * @author :master
 * @date :20200610
 */
public class GlobalConstant {

    /**京东 */
    public static final String ORDER_JD ="order.lqd.jd";

    /**淘宝 */
    public static final String ORDER_TB ="order.my.tb";

    /**苏宁 */
    public static final String ORDER_SN ="order.jm.sn";

    /**天猫 */
    public static final String ORDER_TM ="order.my.tm";

    /** 交换机 */
    public static final String ORDER_EXCHANGE = "exchangeWhole";

    /** 交换机绑定规则 */
    public static final String EXCHANGE_BINDING_RULE1 = "*.my.#";
    public static final String EXCHANGE_BINDING_RULE2 = "order.#";
    public static final String EXCHANGE_BINDING_RULE3 = "*.lj.#";
    public static final String EXCHANGE_BINDING_RULE4 = "*.lqd.#";
}
