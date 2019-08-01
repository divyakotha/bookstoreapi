package com.services.store.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.services.store.exception.RecordNotFoundException;
import com.services.store.model.Book;
import com.services.store.repository.BooksRepository;
import com.services.store.service.BooksService;
import com.services.store.vo.BookVo;

@RunWith(MockitoJUnitRunner.class)

public class BookAPITests {

	 @Mock
	    private BooksRepository booksRepository;

	    @InjectMocks
	    private BooksService booksService;
	    @Spy
	    ModelMapper modelMapper;

	    @Test
	    public void findById() throws RecordNotFoundException {
	        // given
	    	Book bk=new Book();
	        bk.setBookId(1L);
            
	        Optional<Book> book = Optional.of(bk);
	        
            
	          doReturn(book).when(booksRepository).findById(1L);

	        // when
	        BookVo bookVo = booksService.getBookById(1L);

	        // then
	        assertThat(bookVo.getBookId()).isEqualTo(1L);
	    }

	    
	    @Test
	    public void findByDes() throws RecordNotFoundException {
	        // given
	    	Book bk=new Book();
	        bk.setBookId(1L);
	        bk.setBookDescription("Effective Java 3rd Edition");
            
	        List<Book> books = new ArrayList<>();
	        books.add(bk);
	        Book bk1=new Book();
	        bk.setBookId(1L);
	        bk.setBookDescription("Effective Java 4rd Edition");
	        books.add(bk1);
            
	         doReturn(books).when(booksRepository).findByBooksLike("Effective");

	        // when
	        List<BookVo> bookVo = booksService.findByBooksLike("Effective");

	        // then
	        assertThat(bookVo.size()).isEqualTo(2);
	    }
	    
	   
  
}
