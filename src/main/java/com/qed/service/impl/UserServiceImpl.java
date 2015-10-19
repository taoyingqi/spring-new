package com.qed.service.impl;

import com.qed.entity.User;
import com.qed.service.UserServiceI;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 2015/10/16.
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(User user) {
        em.persist(user);
    }
}
