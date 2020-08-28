package com.cx.seata_demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author cx
 * @Date 2020-08-25
 */
@Getter
@Setter
public class Order {

    private Integer id;

    private Integer userId;

    private String remarks;

    private BigDecimal amount;


}
