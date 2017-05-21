package com.github.stoton.controllers.books;

import com.github.stoton.domain.Address;
import com.github.stoton.domain.Book;
import com.github.stoton.domain.Customer;
import com.github.stoton.repository.AddressRepository;
import com.github.stoton.repository.BookRepository;
import com.github.stoton.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository<Book> booksRepository;

    @Autowired
    private CustomerRepository<Customer> customerRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @GetMapping("/getAll")
    public String getAllBooks(Model model) {
        model.addAttribute("list", booksRepository.getAll());
        return "allBooks";
    }

    @GetMapping("/id/{id:\\d+}")
    public String getAllBooks(@PathVariable long id, Model model) {
        Book book = booksRepository.find(id);
        model.addAttribute("book", book);
        return "specificBook";
    }

    @GetMapping("/addBook")
    public String displayBooks(Model model, BookForm bookForm) {
        model.addAttribute("list", booksRepository.getAll());
        return "/addBook";
    }

    @PostMapping("/addBook")
    public String addBook(BookForm bookForm) {
        Book book = bookForm.convertToBook();


        try {
            booksRepository.save(book);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id:\\d+}")
    public String deleteBook(@PathVariable long id) {
        booksRepository.delete(id);
        return "redirect:/";
    }

    @PutMapping("/update/{id:\\d+}}")
    public String updateBook(@PathVariable long id) {
        Customer customer = customerRepository.find(id);
        Book book = booksRepository.find(id);
        book.setCustomer(customer);
        booksRepository.update(book);
        return "redirect:/";
    }
}
