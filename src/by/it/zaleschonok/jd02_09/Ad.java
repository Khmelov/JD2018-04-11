package by.it.zaleschonok.jd02_09;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Orders", propOrder = {
        "product",
        "price",
        "description",
})
public class Ad {


    @XmlElement(name = "Product", required = true)
    protected String product;
    @XmlElement(name = "Price", required = true)
    protected Price price;
    @XmlElement(name = "Description", required = true)
    protected String description;


    public String getDescription() {
        return description;
    }


    public void setDescription(String value) {
        this.description = value;
    }


    public String getProduct() {
        return product;
    }


    public void setProduct(String value) {
        this.product = value;
    }


    public Price getPrice() {
        return price;
    }


    public void setPrice(Price value) {
        this.price = value;
    }



    @Override
    public String toString() {
        return "\n\tOrders{" +

                "product='" + product + '\'' +
                ", price=" + price +
                ", description=" + description + '\'' +
                '}';
    }
}
