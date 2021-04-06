package com.gp.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gp.book.entity.Book;

@Repository
public interface  BookRepository extends JpaRepository<Book,Long>{

}
