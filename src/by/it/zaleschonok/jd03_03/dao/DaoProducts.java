package by.it.zaleschonok.jd03_03.dao;


import by.it.zaleschonok.jd03_03.beans.Products;
import by.it.zaleschonok.jd03_03.beans.Users;
import by.it.zaleschonok.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Пример для универсального DAO
//public class DaoProducts extends UniversalDAO<Products>{
//
//    public DaoProducts() {
//        super(new Products(), "products");
//    }
//
//}

public  class DaoProducts extends AbstractDao implements InterfaceDAO<Products>{

    @Override
    public Products read(int id) throws SQLException {
        List<Products> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Products product) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`products`(`product`, `price`) " +
                        "VALUES ('%s',%d)",
                product.getProduct(), product.getPrice());
        int id = executeUpdate(sql);
        if (id > 0) {
            product.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Products product) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `products` " +
                        "SET `product`='%s', `price`=%d WHERE id=%d",
                product.getProduct(), product.getPrice(), product.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Products product) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `products` WHERE id=%d",
                product.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Products> getAll(String whereAndOrder) throws SQLException {
        List<Products> products = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `product`, `price` FROM `products` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Products product = new Products(
                        resultSet.getInt("id"),
                        resultSet.getString("product"),
                        resultSet.getInt("price")
                );
                products.add(product);
            }
        }
        return products;
    }
}
