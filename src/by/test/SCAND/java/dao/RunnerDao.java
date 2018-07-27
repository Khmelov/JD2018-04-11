package by.test.SCAND.java.dao;

import by.test.SCAND.java.bean.Clients;
import by.test.SCAND.java.bean.FileInput;
import by.test.SCAND.java.bean.Goods;
import by.test.SCAND.java.bean.User;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

public class RunnerDao {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        Clients client = new Clients(0,"DaoTest");
        dao.clients.create(client);
        client.setRoles("TestDaoRoles");
        dao.clients.update(client);
        System.out.println(client);

        User user = new User(0,"NameUserTest","AddTest","PhoneTest",2);
        dao.user.create(user);
        System.out.println(user);
        user.setPhone("+375291112233");

        dao.user.update(user);
        System.out.println(user);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = FileInput.getBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Goods goods = new Goods(0,"car","description",20,bufferedImage,1);
        dao.goods.create(goods);
//        dao.goods.delete(goods);
        System.out.println(dao.goods.getAll(""));


    }
}
