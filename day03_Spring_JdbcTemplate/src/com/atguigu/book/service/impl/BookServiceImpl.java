package com.atguigu.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.book.dao.BookDao;
import com.atguigu.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao dao;
	
	@Override
	public void buyBook(String bid, String uid) {
		Integer price = dao.selectPrice(bid);
		dao.updateSt(bid);
		dao.updateBalance(uid, price);
	}
}
