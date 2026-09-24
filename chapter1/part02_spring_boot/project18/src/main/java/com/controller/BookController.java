package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.Book;
import com.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Hiển thị danh sách sách
    @GetMapping
    public String listBooks(Model model) {

        model.addAttribute(
                "books",
                bookService.getAllBooks());

        return "books";
    }

    // Hiển thị form thêm sách
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute(
                "book",
                new Book());

        return "add-book";
    }

    // Lưu sách
    @PostMapping("/save")
    public String saveBook(
            @ModelAttribute Book book) {

        bookService.saveBook(book);

        return "redirect:/books";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        Book book = bookService
                .getBookById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Không tìm thấy Book ID: " + id));

        model.addAttribute("book", book);

        return "edit-book";
    }

    // Xóa sách
    @PostMapping("/delete/{id}")
    public String deleteBook(
            @PathVariable Long id) {

        bookService.deleteBook(id);

        return "redirect:/books";
    }
}
