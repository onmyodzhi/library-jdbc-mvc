package com.aleksandr.mvc_part2.controllers;

import com.aleksandr.mvc_part2.dao.BookDao;
import com.aleksandr.mvc_part2.dao.PersonDAO;
import com.aleksandr.mvc_part2.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookDao bookDao;
    private final PersonDAO personDAO;

    public BooksController(BookDao bookDao, PersonDAO personDAO) {this.bookDao = bookDao;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDao.index());
        return "books/index";
    }

    @GetMapping("/{book_id}")
    public String show(@PathVariable("book_id") int bookId, Model model) {
        model.addAttribute("book_id", personDAO.show(bookId));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping
    public String create(@PathVariable("bool") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{book_id}/edit")
    public String edit(Model model, @PathVariable("book_id") int bookId) {
        model.addAttribute("book", bookDao.show(bookId));
        return "books/edit";
    }

    @PatchMapping("/{book_id}")
    public String update(@PathVariable("book_id") int bookId,
                         @ModelAttribute("book")@Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        bookDao.save(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{book_id}")
    public String delete(@PathVariable("book_id") int bookId) {
        bookDao.delete(bookId);
        return "redirect:/books";
    }
}
