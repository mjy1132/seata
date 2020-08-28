package com.cx.seata_demo.service;

import com.cx.seata_demo.entity.Order;
import com.cx.seata_demo.entity.UserAccount;
import com.cx.seata_demo.mapper.OrderMapper;
import com.cx.seata_demo.mapper.UserAccountMapper;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Date;

/**
 * @Author cx
 * @Date 2020-08-25
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderDao;

    @Autowired
    private UserAccountMapper userAccountDao;


    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.BASE)
    public void createOrder(Order order) throws Exception {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(order.getUserId());
        userAccount.setBalance(order.getAmount());
        userAccount.setLastUpdateTime(new Date());
        orderDao.save(order);
        int result = userAccountDao.updateBalance(userAccount);
        if(result == 0){
            throw new Exception("余额不足");
        }


    }

}
