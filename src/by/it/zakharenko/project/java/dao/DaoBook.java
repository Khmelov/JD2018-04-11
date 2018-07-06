package by.it.zakharenko.project.java.dao;

import by.it.zakharenko.project.java.beans.Book;
import by.it.zakharenko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoBook extends AbstractDao implements InterfaceDAO<Book> {

    @Override
    public Book read(long id) throws SQLException {
            return null;
    }

    @Override
    public boolean create(Book book) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`books`(`description`, `name`, `author`, `genre`, `pages`, `price`, `users_id`) " +
                        "VALUES ('%s','%s','%s','%s',%d,%f,%d)",
                book.getDescription(), book.getName(), book.getAuthor(), book.getGenre(), book.getPages(), book.getPrice(), book.getUsers_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            book.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `books` " +
                        "SET `description`='%s', `name`='%s', `author`='%s', `genre`='%s', `pages`='%d', `price`='%f'," +
                        "`users_id`=%d WHERE id=%d",
                book.getDescription(), book.getName(), book.getAuthor(), book.getGenre(), book.getPages(), book.getPrice(), book.getUsers_id(), book.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Book book) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `books` WHERE id=%d",
                book.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Book> getAll(String whereAndOrder) throws SQLException {
        List<Book> books = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `description`, `name`, `author`, `genre`, `pages`, `price`, `users_id` FROM `books` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getString("genre"),
                        resultSet.getInt("pages"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("users_id")
                );
                books.add(book);
            }
        }
        return books;
    }
}