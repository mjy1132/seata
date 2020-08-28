package com.cx.seata_demo.mapper;

import com.cx.seata_demo.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


public interface UserAccountMapper {

   int updateBalance(UserAccount userAccount);
}
