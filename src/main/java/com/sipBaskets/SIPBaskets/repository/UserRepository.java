package com.sipBaskets.SIPBaskets.repository;

import com.sipBaskets.SIPBaskets.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Users findByUserName(String userName);
}
