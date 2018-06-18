package by.it.obmetko.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.*;
import java.io.*;


        public class TaskB {
    static JAXBContext jaxbContext;
    static Unmarshaller unmarshaller;
    static Marshaller marshaller;
    static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

            public static void main(String[] args) {
                try {
                        jaxbContext = JAXBContext.newInstance(Persons.class);
                        unmarshaller = jaxbContext.createUnmarshaller();
                        marshaller = jaxbContext.createMarshaller();
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }

                Persons persons = readXml();
                String json = getJson(persons);
                Persons persons1= readJson(json);
                saveXml(persons1);
            }


            public static Persons readXml() {
                Persons persons = null;
                try {
                        String xmlSource = System.getProperty("user.dir") + "/src/by/it/obmetko/jd02_09/Persons+xsd.xml";
                       persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                return persons;
            }

            public static String getJson(Persons persons) {
                String json = gson.toJson(persons);
                System.out.println(json);
                return json;
            }

            public static Persons readJson(String json) {
                Persons persons1 = gson.fromJson(json, Persons.class);
                try {
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    } catch (PropertyException e) {
                        e.printStackTrace();
                    }
                StringWriter out = new StringWriter();
                try {
                        marshaller.marshal(persons1, out);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                System.out.println(out.toString());
                return persons1;
            }

            public static void saveXml(Persons persons1) {
                String xmlTarget = System.getProperty("user.dir") + "/src/by/it/obmetko/jd02_09/Persons+xsd.xml";
                try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                        marshaller.marshal(persons1, outputStream);
                    } catch (IOException | JAXBException e) {
                        e.printStackTrace();
                    }
            }
}


