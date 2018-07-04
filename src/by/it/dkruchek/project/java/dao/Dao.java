package by.it.dkruchek.project.java.dao;

public class Dao {

    private static Dao dao;
    private Dao(){
        role = new DaoRole();
        employee = new DaoEmployee();
        vacation = new DaoVacation();
    }

    public DaoVacation vacation;
    public DaoEmployee employee;
    public DaoRole role;

    public static Dao getDao(){
    if (dao==null){
        synchronized (Dao.class){
            if (dao == null)
                dao = new Dao();
        }

    }
    return dao;
}
}
