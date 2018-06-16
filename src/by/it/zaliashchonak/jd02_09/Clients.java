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
