package com.gerenciar.livro.services;

import com.gerenciar.livro.dtos.CreateBookDTO;
import com.gerenciar.livro.dtos.UpdateBookDTO;
import com.gerenciar.livro.entities.Book;
import com.gerenciar.livro.enums.BookStatus;
import com.gerenciar.livro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Book> create(@RequestBody CreateBookDTO createBookDTO){
        Book book = new Book();
        book.setTitle(createBookDTO.getTitle());
        book.setAuthor(createBookDTO.getAuthor());
        book.setPrice(createBookDTO.getPrice());
        book.setStatus(createBookDTO.getStatus());

        Book newBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> allBooks = bookRepository.findAll();
        return ResponseEntity.ok(allBooks);
    }

    public ResponseEntity<Optional<Book>> findBookById(@PathVariable Long id){
        Optional<Book> bookById = bookRepository.findById(id);
        return ResponseEntity.ok(bookById);
    }

    public ResponseEntity<List<Book>> findBookByStatus(@PathVariable BookStatus status){
        List<Book> booksByStatus = bookRepository.findByStatus(status);
        return ResponseEntity.ok(booksByStatus);
    }

    public ResponseEntity<?> deleteBookById(@PathVariable Long id){
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }

    public ResponseEntity<Book> updateBookById(@RequestBody UpdateBookDTO updateBookDTO, @PathVariable Long id){
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updateBookDTO.getTitle());
            book.setAuthor(updateBookDTO.getAuthor());
            book.setPrice(updateBookDTO.getPrice());
            book.setStatus(updateBookDTO.getStatus());

            Book updatedBook = bookRepository.save(book);
            return ResponseEntity.ok(updatedBook);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
