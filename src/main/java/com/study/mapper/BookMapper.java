package com.study.mapper;

import com.study.entity.Book;
import com.study.entity.Borrow;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;


import java.util.List;

public interface BookMapper {

    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "bid",property = "bid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "name",property = "sname"),
            @Result(column = "title",property = "title"),
            @Result(column = "time",property = "time"),
    })
    @Select("select * from borrow left join book on borrow.bid = book.bid left join student on borrow.sid = student.sid")
    List<Borrow> getBorrowList();

    @Select("select count(bid) from book")
    int getBookCount();

    @Select("select sum(price) from book where status = 1")
    double getTurnover();

    @Select("select * from book where status = 0")
    List<Book> getAvailableBookList();

    @Insert("insert into borrow(bid, sid, time) values(#{bid},#{sid},now())")
    int addBorrowInfo(@Param("bid") int bid,@Param("sid") int sid);

    @Delete("delete from borrow where id = #{id}")
    int deleteBorrowInfoById(int id);

    @Select("select * from book")
    List<Book> getBookList();

    @Delete("delete from book where bid = #{bid}")
    int deleteBook(int bid);

    @Insert("insert into book(title,`desc`,price) values(#{title},#{desc},#{price})")
    int insertBook(@Param("title") String title,@Param("desc") String desc,@Param("price") double price);

    @Select("select * from book where title like(concat('%',#{title},'%'))")
    List<Book> searchBook(String title);
}
