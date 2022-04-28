package com.sipBaskets.SIPBaskets.repository;

import com.sipBaskets.SIPBaskets.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}
