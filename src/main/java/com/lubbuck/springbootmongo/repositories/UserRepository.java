package com.lubbuck.springbootmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lubbuck.springbootmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
