package com.wave4.restaurante.dtos;

import com.wave4.restaurante.dtos.interfaces.ConverterInterface;
import com.wave4.restaurante.entities.Dish;
import com.wave4.restaurante.entities.Order;
import com.wave4.restaurante.entities.Table;
import com.wave4.restaurante.enums.OrderStatus;
import com.wave4.restaurante.utils.DateUtils;

import java.util.List;

public class OrderDTO implements ConverterInterface<Order, OrderDTO> {

    private Long id;
    private Table table;
    private List<Dish> dishes;
    private Double totalConsumed;
    private OrderStatus orderStatus;


    @Override
    public Order convert() {
        if (this.id != null) {
            new Order(id, table, dishes, totalConsumed, orderStatus);
        }
        return new Order(DateUtils.getCurrentTimeMillis(), table, dishes, totalConsumed, OrderStatus.OPENED);
    }

    @Override
    public OrderDTO convert(Order order) {
        this.id = order.getId();
        this.table = order.getTable();
        this.dishes = order.getDishes();
        this.totalConsumed = order.getTotalConsumed();
        this.orderStatus = order.getStatus();
        return this;
    }
}
