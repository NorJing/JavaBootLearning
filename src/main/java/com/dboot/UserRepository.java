package com.dboot;

import org.springframework.data.repository.CrudRepository;

import com.dboot.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
