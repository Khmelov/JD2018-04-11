package by.it.obmetko.project.java.DAO;

import by.it.obmetko.project.java.connection.DbConnection;

import java.sql.*;

public class DAO {
    private static DAO dao;

    public RoleDAO roleDAO;
    public BuyerDAO buyerDAO;
    public ListOfPurchasesDAO listOfPurchasesDAO;
    public BookDAO bookDAO;
    public CategoryDAO categoryDAO;
    public CatalogDAO catalogDAO;


    public static DAO getDAO() {
        if (dao == null) {
            dao = new DAO();
            dao.roleDAO = new RoleDAO();
            dao.buyerDAO = new BuyerDAO();
            dao.listOfPurchasesDAO = new ListOfPurchasesDAO();
            dao.bookDAO = new BookDAO();
            dao.categoryDAO = new CategoryDAO();
            dao.catalogDAO = new CatalogDAO();
        }
        return dao;
    }

    private static int create(String sql) throws SQLException {
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
                           ) {
            int recCount = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            int id=-1;
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next())
                    id= keys.getInt(1);
                keys.close();
            }
            return id;
        }

    }

    public static int executeUpdate(String sql) throws SQLException {
        if (sql.toUpperCase().trim().startsWith("INSERT "))
                        return create(sql);
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return statement.executeUpdate(sql);
        }
    }
}