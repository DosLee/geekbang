package org.geek.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 描述:
* 订单表
*
* @author lil
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
    * 订单表主键
    */
    private Long id;

    /**
    * 用户ID
    */
    private Long userId;

    /**
    * 订单ID
    */
    private Long orderId;

    /**
    * 商品ID
    */
    private Integer goodsId;
}
