package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/23
 */
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(String nameA,String nameB){
        User userA = userDao.selectOne(nameA);
        User userB = userDao.selectOne(nameB);

        if(userA.getMoney() > userB.getMoney()){
            Float residueMoney = (userA.getMoney() - userB.getMoney());
            userA.setMoney(userA.getMoney() - residueMoney);
            userB.setMoney(userB.getMoney() + residueMoney);
            userDao.save(userA);
            userDao.save(userB);
        }else {
            Float residueMoney = (userB.getMoney() - userA.getMoney());
            userA.setMoney(userA.getMoney() - residueMoney);
            userB.setMoney(userB.getMoney() + residueMoney);
            userDao.save(userA);
            userDao.save(userB);
        }
    }

}
