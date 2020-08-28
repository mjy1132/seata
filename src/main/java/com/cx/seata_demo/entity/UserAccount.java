package com.cx.seata_demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author cx
 * @Date 2020-08-25
 */
@Getter
@Setter
public class UserAccount {

    private Integer id;

    private BigDecimal balance;

    private Date lastUpdateTime;

}
