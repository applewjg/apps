package com.applewjg.repository;

import com.applewjg.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by baidu on 16/4/14.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
