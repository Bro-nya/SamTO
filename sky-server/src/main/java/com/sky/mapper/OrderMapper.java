package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param orders
     */
    void insert(Orders orders);

    /**
     * 根据订单状态和下单时间查询订单
     * @param status
     * @param orderTime
     * @return
     */
    @Select("select * from orders where status=#{status} and order_time<#{orderTime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status, LocalDateTime orderTime);

    /**
     * 更新订单表
     * @param orders
     */
    void update(Orders orders);

    /**
     * 根据id查订单
     * @param id
     * @return
     */
    @Select("SELECT * FROM orders WHERE id=#{id}")
    Orders getById(Long id);

    /**
     * 根据动态条件统计营业额数据
     * @return
     */
    Double sumByMap(Map map);
}
