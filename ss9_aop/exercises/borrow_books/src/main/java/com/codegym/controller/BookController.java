package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.OrderBook;
import com.codegym.service.IBookService;
import com.codegym.service.IOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IOrderBookService iOrderBookService;
    @GetMapping("")
    public ModelAndView showBook() {
        ModelAndView modelAndView = new ModelAndView("book/list");
        List<Book> books = iBookService.findAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showDetailBook(@PathVariable int id){
    Book book = iBookService.findById(id);
    ModelAndView modelAndView = new ModelAndView("book/view");
    modelAndView.addObject("book", book);
    return modelAndView;
    }
    @GetMapping("/order/{id}")
    public ModelAndView orderBook(@PathVariable int id) throws Exception {
        Book book = iBookService.findById(id);

        book.setCount(book.getCount()-1);
        if (book.getCount() == -1) {
            throw new Exception();
        }
        iBookService.save(book);
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(book);
        long code = (long)(Math.random() * (99999 - 10000 ) + 10000);
        orderBook.setCode (code);
        iOrderBookService.save(orderBook);
        List<Book> books = iBookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/view");
        modelAndView.addObject("book", book);
        modelAndView.addObject("code",code);
        return modelAndView;

    }
    @GetMapping("/return/{id}")
    public ModelAndView returnBook(@PathVariable int id){
        Book book = iBookService.findById(id);
        OrderBook orderBook = new OrderBook();
        ModelAndView modelAndView = new ModelAndView("book/return");
        modelAndView.addObject("book", book);
        modelAndView.addObject("orderBook", orderBook);
        return modelAndView;
    }
    @PostMapping("/return")
    public ModelAndView acceptReturnBook(@RequestParam int id, @ModelAttribute OrderBook orderBook){

        OrderBook orderBookFindByCode = iOrderBookService.findOrderBookByCode(orderBook.getCode(),id);
        Book book = iBookService.findById(id);

        if(orderBookFindByCode!=null){
            book.setCount(book.getCount()+1);
            iBookService.save(book);
            ModelAndView modelAndView = new ModelAndView("book/return");
            modelAndView.addObject("mess", "return book success");
            modelAndView.addObject("book", book);
            modelAndView.addObject("orderBook", orderBookFindByCode);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("book/return");
            modelAndView.addObject("mess", "valid code");
            modelAndView.addObject("book", book);
            modelAndView.addObject("orderBook", new OrderBook());
            return modelAndView;
        }
    }
    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "book/error";
    }
}
