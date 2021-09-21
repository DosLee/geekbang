package org.geek.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.geek.domain.Order;

/**
* 描述:
* 订单表
*
* @author lil
*/
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    int batchInsert(@Param("list") List<Order> list);
}
