package com.study.service;

import com.study.entity.Book;
import com.study.entity.Borrow;

import java.util.List;

public interface BookService {
    List<Borrow> getBorrowList();
    int getBookCount();
    double getTurnover();
    List<Book> getAvailableBookList();
    int addBorrowInfo(int bid,int sid);
    int deleteBorrowInfoById(int id);
    List<Book> getBookList();
    int deleteBook(int bid);
    int insertBook(String title,String desc,double price);
    List<Book> searchBook(String title);

}
