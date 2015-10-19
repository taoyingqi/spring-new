package com.qed.repository;

import com.qed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/16.
 */
public interface UserReps extends JpaRepository<User, Serializable> {
}
