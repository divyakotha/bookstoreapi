package com.services.store.service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.store.exception.RecordNotFoundException;
import com.services.store.model.Book;
import com.services.store.repository.BooksRepository;
import com.services.store.vo.BookVo;

@Service
public class BooksService {

	@Autowired
	BooksRepository repository;

	@Autowired
    private ModelMapper modelMapper;

	public BookVo getBookById(Long bookId) throws RecordNotFoundException {
		Optional<Book> book = repository.findById(bookId);

		if (book.isPresent()) {
			BookVo bookVo = modelMapper.map(book.get(), BookVo.class);
			 
			return bookVo;
		} else {
			throw new RecordNotFoundException(Book.class,"No Book record exist for given id",bookId.toString());
		}
	}

	public BookVo createOrUpdateBook(BookVo bookVo) {
		
		Book book = modelMapper.map(bookVo, Book.class);
		Optional<Book> bookExists = repository.findById(book.getBookId());
		if (bookExists.isPresent()) {
			Book book1 = bookExists.get();
			book1.setBookPrice(book.getBookPrice());
			book1.setPriceUpdatedDate(new Date());
			repository.save(book1);
		} else {
			repository.save(book);

		}
		return bookVo;
	}

	public void deleteBookById(Long id) throws RecordNotFoundException {
		Optional<Book> book = repository.findById(id);

		if (book.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException(Book.class,"No Book record exist for given id",id.toString());
		}
	}
	
	public List<BookVo> findByBooksLike(String desc) throws RecordNotFoundException{
		
		List<Book> books = repository.findByBooksLike(desc);
		Type listType = new TypeToken<List<BookVo>>(){}.getType();
		List<BookVo> finalList = modelMapper.map(books,listType);
		 if(finalList.isEmpty()) {
				throw new RecordNotFoundException(Book.class,"No Book record exist for given description",desc);
			}		
		return finalList;
		
	}
}

