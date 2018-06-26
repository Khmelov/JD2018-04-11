package by.it.shekh.project.java.beans;

public class FacadeOrders {

    long idfacade_order;
    long id_facade;
    long idOrder;

    public FacadeOrders() {

    }

    public FacadeOrders(long idfacade_order, Long id_facade, Long idOrder) {
        this.idfacade_order = idfacade_order;
        this.id_facade = id_facade;
        this.idOrder = idOrder;
    }

    public Long getIdfacade_order() {
        return idfacade_order;
    }

    public void setIdfacade_order(Long idfacade_order) {
        this.idfacade_order = idfacade_order;
    }

    public Long getId_facade() {
        return id_facade;
    }

    public void setId_facade(Long id_facade) {
        this.id_facade = id_facade;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "FacadeOrders{" +
                "idfacade_order=" + idfacade_order +
                ", id_facade=" + id_facade +
                ", idOrder=" + idOrder +
                '}';
    }
}
