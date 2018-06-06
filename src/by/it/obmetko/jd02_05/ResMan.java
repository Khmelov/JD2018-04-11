package by.it.obmetko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;


    public enum ResMan {
        INSTANCE;

        private final String path = "by.it.obmetko.jd02_05.lang.language";

        public void setLocale(Locale locale) {
            this.locale = locale;
            resourceBundle = ResourceBundle.getBundle(path, locale);
        }

        private Locale locale = Locale.getDefault();

        private ResourceBundle resourceBundle;

        ResMan() {
            resourceBundle = ResourceBundle.getBundle(path, locale);
        }

        String get(String key) {
            return resourceBundle.getString(key);
        }
    }

