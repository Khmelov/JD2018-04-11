package by.it.obmetko.project.java.DAO;

import by.it.obmetko.project.java.DAO.beens.Category;
import by.it.obmetko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DAO implements I_DAO<Category> {

    @Override
    public boolean create(Category category) throws SQLException {
        category.setId(0);
        int id = executeUpdate(
                String.format("INSERT INTO `category`(`categoryName`, `Catalog_id`) VALUES ('%s','%d')",
                        category.getCategoryName(), category.getCatalog_id()));
        if (id > 0) category.setId(id);
        return id > 0;
    }

    @Override
    public Category read(int id) throws SQLException {
        List<Category> categoryList = getAll(" where id=" + id);
        return !categoryList.isEmpty() ? categoryList.get(0) : null;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return 1 == executeUpdate(
                String.format("UPDATE `category` SET `categoryName`='%s',`Catalog_id`='%d' WHERE id=%d",
                        category.getCategoryName(), category.getCatalog_id(), category.getId()));
    }

    @Override
    public boolean delete(Category category) throws SQLException {
        return 1 == executeUpdate(
                String.format("DELETE FROM `category` WHERE id=%d", category.getId()));
    }

    @Override
    public List<Category> getAll(String where) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
                String sql = "SELECT * FROM `category`" + where + ";";
        try (Connection connection = DbConnection.getConnection();
                        Statement statement = connection.createStatement();
                         ResultSet categories = statement.executeQuery(sql)
                            ) {
                while (categories.next()) {
                    categoryList.add(
                            new Category(
                                    categories.getInt("id"),
                                    categories.getString("categoryName"),
                                    categories.getInt("Catalog_id")
                            )
                    );
                }
            }
            return categoryList;
        }
    }