package by.it.kurmaz.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class JSONtoXMLConverter extends Converter {

    private String json;

    JSONtoXMLConverter(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    void load(String line) {
        json = line;
    }

    @Override
    void convert() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(json, beanClass);
    }

    @Override
    String getText() {
        return json;
    }
}
