package com.study.service.impl;

import com.study.entity.Book;
import com.study.entity.Borrow;
import com.study.mapper.BookMapper;
import com.study.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Borrow> getBorrowList() {
        return bookMapper.getBorrowList();
    }

    @Override
    public int getBookCount() {
        return bookMapper.getBookCount();
    }

    @Override
    public double getTurnover() {
        return bookMapper.getTurnover();
    }

    @Override
    public List<Book> getAvailableBookList() {
        return bookMapper.getAvailableBookList();
    }

    @Override
    public int addBorrowInfo(int bid,int sid) {
        return bookMapper.addBorrowInfo(bid, sid);
    }

    @Override
    public int deleteBorrowInfoById(int id) {
        return bookMapper.deleteBorrowInfoById(id);
    }

    @Override
    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    @Override
    public int deleteBook(int bid) {
        return bookMapper.deleteBook(bid);
    }

    @Override
    public int insertBook(String title, String desc, double price) {
        return bookMapper.insertBook(title, desc, price);
    }

    @Override
    public List<Book> searchBook(String title) {
        return bookMapper.searchBook(title);
    }
}
