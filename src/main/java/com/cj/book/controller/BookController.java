package com.cj.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cj.book.dto.BookDTO;
import com.cj.book.service.BookSearchKeywordList;
import com.cj.book.service.BookService;

@Controller
public class BookController {

	@RequestMapping("/bookList")
	//JSONP방식으로 JSON데이터를 보내준다
	public void getBookList(HttpServletRequest request, HttpServletResponse response){
		String keyword = request.getParameter("keyword");
		String callback = request.getParameter("callback");
		BookDTO dto = new BookDTO();
		dto.setBtitle(keyword);
		//서비스 객체 생성.
		BookService service = new BookSearchKeywordList();
		String result = service.execute(dto);

		response.setContentType("text/plain; charset=utf8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(callback+"("+result+")");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
