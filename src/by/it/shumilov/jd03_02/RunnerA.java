package by.it.shumilov.jd03_02;

import by.it.shumilov.jd03_02.beans.Avto;
import by.it.shumilov.jd03_02.beans.Order;
import by.it.shumilov.jd03_02.beans.User;
import by.it.shumilov.jd03_02.crud.CrudAvto;
import by.it.shumilov.jd03_02.crud.CrudOrder;
import by.it.shumilov.jd03_02.crud.CrudUser;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunnerA {
    public static void main(String[] args) throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CrudUser crudUser = new CrudUser();
        CrudAvto crudAvto = new CrudAvto();
        CrudOrder crudOrder = new CrudOrder();

        Avto avto = new Avto(0,"1","2","3","4",1988,"2121 as-4", 22.2, null);

        Order order = new Order(0,sdf.parse("2015-05-26"),10 ,null ,12.2, 312, 12.4, 2,2);
        User user = new User(0,"testuser","testuser","testuser",2);


        if(crudUser.create(user)){
            System.out.println("Create "+ user);
        }

        User user1 = crudUser.read(user.getId());
        if(user1 != null){
            System.out.println("Read " + user1);
        }

        user.setEmail("321654");
        if(crudUser.update(user)){
            System.out.println("Update " +crudUser.read(user.getId()));

        }
        if(crudUser.delete(user)){
            System.out.println("Delete " + user);
        }





        if(crudAvto.create(avto)){
            System.out.println("Create "+ avto);
        }

        Avto avto1 = crudAvto.read(avto.getId());
        if(avto1 != null){
            System.out.println("Read " + avto1);
        }

        avto.setModel("321654");
        if(crudAvto.update(avto)){
            System.out.println("Update " +crudAvto.read(avto.getId()));

        }
        if(crudAvto.delete(avto)){
            System.out.println("Delete " + avto);
        }





        if(crudOrder.create(order)){
            System.out.println("Create "+ order);
        }

        Avto order1 = crudAvto.read(avto.getId());
        if(order1 != null){
            System.out.println("Read " + order1);
        }

        order.setEndorder(new Date());
        if(crudOrder.update(order)){
            System.out.println("Update " +crudOrder.read(order.getId()));

        }
        if(crudOrder.delete(order)){
            System.out.println("Delete " + order);
        }


    }
}
