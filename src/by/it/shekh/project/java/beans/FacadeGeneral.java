package by.it.shekh.project.java.beans;

public class FacadeGeneral {
    long id_facade;
    String facade_name;
    String facade_dimensions;
    String facade_description;
    double facade_price;
    String facade_specs;

    public FacadeGeneral() {

    }

    public FacadeGeneral(long id_facade, String facade_name, String facade_dimensions, String facade_description, double facade_price, String facade_specs) {
        this.id_facade = id_facade;
        this.facade_name = facade_name;
        this.facade_dimensions = facade_dimensions;
        this.facade_description = facade_description;
        this.facade_price = facade_price;
        this.facade_specs = facade_specs;
    }

    public long getId_facade() {
        return id_facade;
    }

    public void setId_facade(long id_facade) {
        this.id_facade = id_facade;
    }

    public String getFacade_name() {
        return facade_name;
    }

    public void setFacade_name(String facade_name) {
        this.facade_name = facade_name;
    }

    public String getFacade_dimensions() {
        return facade_dimensions;
    }

    public void setFacade_dimensions(String facade_dimensions) {
        this.facade_dimensions = facade_dimensions;
    }

    public String getFacade_description() {
        return facade_description;
    }

    public void setFacade_description(String facade_description) {
        this.facade_description = facade_description;
    }

    public double getFacade_price() {
        return facade_price;
    }

    public void setFacade_price(double facade_price) {
        this.facade_price = facade_price;
    }

    public String getFacade_specs() {
        return facade_specs;
    }

    public void setFacade_specs(String facade_specs) {
        this.facade_specs = facade_specs;
    }

    @Override
    public String toString() {
        return "FacadeGeneral{" +
                "id_facade=" + id_facade +
                ", facade_name='" + facade_name + '\'' +
                ", facade_dimensions='" + facade_dimensions + '\'' +
                ", facade_description='" + facade_description + '\'' +
                ", facade_price=" + facade_price +
                ", facade_specs='" + facade_specs + '\'' +
                '}';
    }
}
