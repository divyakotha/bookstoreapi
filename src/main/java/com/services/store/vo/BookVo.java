package com.services.store.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookVo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long bookId;

    
    private String bookTitle;

    
    private String bookAuthor;


    private Integer bookPages;


    private String bookIsbn;


    private BigDecimal bookPrice;

    
    private String bookDescription;


	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public Integer getBookPages() {
		return bookPages;
	}


	public void setBookPages(Integer bookPages) {
		this.bookPages = bookPages;
	}


	public String getBookIsbn() {
		return bookIsbn;
	}


	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}


	public BigDecimal getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}


	public String getBookDescription() {
		return bookDescription;
	}


	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}


}
