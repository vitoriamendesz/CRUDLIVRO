package com.gerenciar.livro.repositories;

import com.gerenciar.livro.entities.Book;
import com.gerenciar.livro.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByStatus(BookStatus status);
}
