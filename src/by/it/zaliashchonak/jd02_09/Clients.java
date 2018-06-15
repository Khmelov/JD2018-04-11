package by.it.zaliashchonak.jd02_09;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "client"
})
@XmlRootElement(name = "Clients")
public class Clients {

    @XmlElement(name = "Client", required = true)
    protected List<Client> client;

    /**
     * Gets the value of the person property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the person property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerson().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Client }
     *
     *
     */
    public List<Client> getClient() {
        if (client == null) {
            client = new ArrayList<Client>();
        }
        return this.client;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "client=" + client +
                '}';
    }
}
