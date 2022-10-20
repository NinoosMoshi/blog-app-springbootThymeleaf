package com.ninos.repository;

import com.ninos.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/*
@Repository: we don't need to put this annotation because JpaRepository has already @Repository and @Transaction.
for proving: go inside JpaRepository -> click on arrow on the left of method jpaRepository -> choose SimpleJpaRepository
and you will see it's annotated by @Repository and @Transaction.
 */

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
