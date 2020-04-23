package pl.javastart.springangularrouting.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.javastart.springangularrouting.model.Book;
import pl.javastart.springangularrouting.repository.BookRepo;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private BookRepo bookRepo;

    public BookRestController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<Book> books = bookRepo.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent())
        {
            return ResponseEntity.ok(book.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        if (book.getId()==null)
        {
            return persistBook(book);
        }else {
            Book newBook = new Book();
            newBook.setTitle(book.getTitle());
            newBook.setAuthor(book.getAuthor());
            newBook.setIsbn(book.getIsbn());
             return persistBook(newBook);
        }

    }

    private ResponseEntity<?> persistBook(@RequestBody Book book) {
        Book bookSaved = bookRepo.save(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookSaved.getId())
                .toUri();

        return ResponseEntity.created(location).body(book);
    }


}
