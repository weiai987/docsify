package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单实例
 * @author :master
 * @date :20200611
 */

@Data
public class Order  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;

    private String orderName;

    private String orderType;

    private String orderDetail;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDetail='" + orderDetail + '\'' +
                '}';
    }
}