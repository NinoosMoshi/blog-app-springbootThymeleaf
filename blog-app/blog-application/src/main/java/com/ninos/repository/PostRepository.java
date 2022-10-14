package com.ninos.repository;

import com.ninos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

//      @Query("select p.url from Post p where p.url=?1")

      Optional<Post> findByUrl(String url);

}
