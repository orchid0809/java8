package com.orchid0809;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by orchid0809 on 2018/3/4.
 */
public class StreamTest {

    @Test
    public void test1(){

       /* String str = books().stream().map(book -> book.getId()+"").collect(Collectors.joining(","));
        System.out.println(str);

        List<Integer> list = books().stream().map(book->book.getId()).collect(Collectors.toList());
        System.out.println(list);

        Map<Integer,Book> booksMap = books().stream().collect(Collectors.toMap(book->book.getId(),book->book));
        System.out.println(booksMap);

        List<String> strList = books().stream().sorted((book1,book2)->book1.getPublicDate().isAfter(book2.getPublicDate())?-1:1).limit(1).map(book->book.getName()).collect(Collectors.toList());
        System.out.println(strList);

        Optional<Book> op = books().stream().max((book1, book2)->book1.getPublicDate().isAfter(book2.getPublicDate())?1:-1);
        System.out.println(op);

        Book b = books().stream().max((book1, book2)->book1.getPublicDate().isAfter(book2.getPublicDate())?1:-1).get();
        System.out.println(b);*/

       Book b2 = books().stream().collect(Collectors.minBy(Comparator.comparing(book->book.getPublicDate()))).get();
        System.out.println(b2);

       Map<String,List<Book>> bookMapList = books().stream().collect(Collectors.groupingBy(book->book.getName()));
        System.out.println(bookMapList);

       Map<String,Long> bookCntMap = books().stream().collect(Collectors.groupingBy(Book::getName, Collectors.counting()));
        System.out.println(bookCntMap);
    }

    private List<Book> books(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"java", LocalDate.parse("2018-03-12")));
        books.add(new Book(2,"c#", LocalDate.parse("2017-12-11")));
        books.add(new Book(3,"java", LocalDate.parse("2016-01-11")));
        books.add(new Book(4,"jetty", LocalDate.parse("2014-02-01")));
        books.add(new Book(5,"tomcat", LocalDate.parse("2014-08-11")));
        return books;
    }
}
