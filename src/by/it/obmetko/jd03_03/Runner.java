package by.it.obmetko.jd03_03;

import by.it.obmetko.jd03_03.DAO.DAO;
import by.it.obmetko.jd03_03.beens.*;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {

        DAO dao = DAO.getDAO();
//Roles
        Role role = dao.roleDAO.read(2);
        System.out.println("вывод 1 записи: " + role + "\n");
        role.setRole("Guest");
        dao.roleDAO.create(role);
        System.out.println("создание: " + role);
        role.setId(8);
        dao.roleDAO.update(role);
        System.out.println("обновление :" + role);
        System.out.println("вывод всех записей: " + dao.roleDAO.getAll(""));
        dao.roleDAO.delete(role);
        System.out.println("удаление: " + role);
        System.out.println("-----------------------------------------------------------------------------------------------------------");
//Buyer
        Buyer buyer = dao.buyerDAO.read(1);
        System.out.println(buyer + "\n");
        buyer.setLogin("buyer" + buyer.getId());
        dao.buyerDAO.create(buyer);
        System.out.println(buyer + "\n");
        buyer.setLogin("buyer" + (buyer.getId() + 1));
        dao.buyerDAO.update(buyer);
        System.out.println(buyer + "\n");
        dao.buyerDAO.delete(buyer);
        List<Buyer> users = dao.buyerDAO.getAll("");
        for (Buyer b : users) {
            System.out.println(b);
        }
        System.out.println("------------------------------------------------------------------------------------------");
//catalog
        Catalog catalog = new Catalog(3, "каталог картин");
        dao.catalogDAO.create(catalog);
        System.out.println("создание: " + catalog);
        System.out.println();
        catalog.setCatalogName("каталог чая");
        dao.catalogDAO.update(catalog);
        System.out.println("обновление :" + catalog);
        System.out.println();
        List<Catalog> ab = dao.catalogDAO.getAll("");
        for (Catalog d : ab) {
            System.out.println(d);
        }
        System.out.println();
        dao.catalogDAO.delete(catalog);
        System.out.println("удаление: " + catalog);
        System.out.println("------------------------------------------------------------------------------------------");
//category
        Category cat = new Category(5, "зелёный крупнолистовой", 2);
        dao.categoryDAO.create(cat);
        System.out.println("создание: " + cat);
        System.out.println();
        cat.setCategoryName("Чёрный");
        dao.categoryDAO.update(cat);
        System.out.println("обновление :" + cat);
        System.out.println();
        List<Category> we = dao.categoryDAO.getAll("");
        for (Category w : we) {
            System.out.println(w);
        }
        System.out.println();
        dao.categoryDAO.delete(cat);
        System.out.println("удаление: " + cat);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
//book
        Book book1 = new Book(0, "Жизнь Васи", "Вася", 100, 1);
        Book book2 = new Book(0, "Жизнь ", "неизвестен", 5000, 3);
        dao.bookDAO.create(book1);
        dao.bookDAO.create(book2);
        System.out.println("создан " + book1);
        System.out.println("создан " + book2);
        System.out.println();
        book2.setAuthor("Бернар Вербер");
        book2.setCategory_id(1);
        book1.setName("день муравья");
        book1.setPrice(500);
        dao.bookDAO.update(book1);
        dao.bookDAO.update(book2);
        System.out.println("обновление: " + book1);
        System.out.println("обновление: " + book2);
        System.out.println();
        List<Book> ads = dao.bookDAO.getAll("");
        for (Book b : ads) {
            System.out.println(b);
        }
        System.out.println();
        dao.bookDAO.delete(book2);
        dao.bookDAO.delete(book1);
        System.out.println("удаление: " + book1);
        System.out.println("удаление: " + book2);
        System.out.println();
        // поиск и вывод по id
        Book book = dao.bookDAO.read(3);
        System.out.println("поиск по id: " + book);
        System.out.println("-------------------------------------------------------------------------------------");
//list of purchases
        ListOfPurchases list = dao.listOfPurchasesDAO.read(2);
        System.out.println("чтение: " + list);
        list.setBooks_id(3); //обновление книги
        System.out.println("обнавление: " + dao.listOfPurchasesDAO.update(list) + "\n" + list);
        dao.listOfPurchasesDAO.create(list);
        System.out.println("создание: " + list);
        System.out.println("чтение всех: " + dao.listOfPurchasesDAO.getAll(""));
        dao.listOfPurchasesDAO.delete(list);
        System.out.println("удаление: " + list);

    }
}