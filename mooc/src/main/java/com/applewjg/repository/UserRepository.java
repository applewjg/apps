package com.applewjg.repository;

import com.applewjg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by baidu on 16/4/13.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
