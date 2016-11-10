package com.cj.book.service;

import com.cj.book.dao.BookDAO;
import com.cj.book.dto.BookDTO;

public class BookSearchKeywordList implements BookService{

	@Override
	public String execute(BookDTO entity){
		
		BookDAO dao = new BookDAO();
		String result = dao.select(entity);
		return result;
	}
}
