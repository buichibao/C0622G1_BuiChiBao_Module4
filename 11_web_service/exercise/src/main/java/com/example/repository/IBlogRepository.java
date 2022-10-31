package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "select  * from blog where  category_id = :id",nativeQuery = true)
    List<Blog> findListBlog(@Param("id") Integer id);

    Optional<Blog> findById(Integer id);
}
