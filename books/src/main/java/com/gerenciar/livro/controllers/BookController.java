package com.gerenciar.livro.controllers;

import com.gerenciar.livro.dtos.CreateBookDTO;
import com.gerenciar.livro.dtos.UpdateBookDTO;
import com.gerenciar.livro.entities.Book;
import com.gerenciar.livro.enums.BookStatus;
import com.gerenciar.livro.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("create-book")
    @Operation(summary = "Criando um Livro.")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookDTO createBookDTO){
        return bookService.create(createBookDTO);
    }

    @GetMapping("find-all-books")
    @Operation(summary = "Buscando todos os Livros.")
    public ResponseEntity<List<Book>> findAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("find-book/{id}")
    @Operation(summary = "Buscando um Livro por Id.")
    public ResponseEntity<Optional<Book>> findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @GetMapping("find-books/{status}")
    @Operation(summary = "Buscando Livros por Status")
    public ResponseEntity<List<Book>> findBooksByStatus(@PathVariable BookStatus status){
        return bookService.findBookByStatus(status);
    }

    @DeleteMapping("delete-book/{id}")
    @Operation(summary = "Deletando um Livro por Id.")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id){
        return bookService.deleteBookById(id);
    }

    @PutMapping("update-book/{id}")
    @Operation(summary = "Atualizando um Livro por Id.")
    public ResponseEntity<Book> updateBookById(@RequestBody UpdateBookDTO updateBookDTO, @PathVariable Long id){
        return bookService.updateBookById(updateBookDTO, id);
    }
}
