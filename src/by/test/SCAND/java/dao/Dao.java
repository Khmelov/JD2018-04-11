package by.test.SCAND.java.dao;


import by.test.SCAND.java.dao.resetDB.DataBase;

public class Dao {

    private static Dao dao;

    public DaoClients clients;
    public DaoUser user;
    public DaoGoods goods;

    private Dao(){
        clients = new DaoClients();
        user = new DaoUser();
        goods = new DaoGoods();
    }
    public static void reset(){
        DataBase.main(new String[]{} );
    }

    public static Dao getDao(){
        if(dao==null){
            synchronized (Dao.class){
                if(dao==null){
                    dao=new Dao();
                }
            }
        }
        return dao;
    }
}
