package com.services.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.store.exception.RecordNotFoundException;
import com.services.store.service.BooksService;
import com.services.store.vo.BookVo;
 
@RestController
@RequestMapping("/books")
public class BooksController
{
    @Autowired
    BooksService service;
 
   
 
    @GetMapping("/{id}")
    public ResponseEntity<BookVo> getBookById(@PathVariable("id") Long id)
    throws RecordNotFoundException {
        BookVo book = service.getBookById(id);
        return new ResponseEntity<>(book, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<BookVo>> getBookByDes(@RequestParam String des)
    throws RecordNotFoundException {
        List<BookVo> books = service.findByBooksLike(des);
        return new ResponseEntity<>(books, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<BookVo> createOrUpdateEmployee(@RequestBody BookVo book)
                                                     {
    	BookVo updated = service.createOrUpdateBook(book);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteBookById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}