package by.it.zakharenko.jd03_03.dao;

import by.it.zakharenko.jd03_03.beans.Book;

public class DaoBook extends UniversalDAO<Book> {
    public DaoBook() {
        super(new Book(), "books");
    }
}
