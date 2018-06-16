package by.it.zaliashchonak.jd02_09;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }


    public Clients createPersons() {
        return new Clients();
    }


    public Client createPerson() {
        return new Client();
    }


    public Ads createAds() {
        return new Ads();
    }


    public Ad createAd() {
        return new Ad();
    }


    public Price createPrice() {
        return new Price();
    }

}
