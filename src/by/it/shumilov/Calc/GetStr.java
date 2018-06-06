package by.it.shumilov.Calc;

import java.util.Locale;
import java.util.ResourceBundle;

class GetStr {
        private static GetStr instance;
        String path = "by.it.shumilov.Calc.lang.language";
        private Locale locale ;
        private ResourceBundle rb ;

        private GetStr(){
            defaultInstance();
        }

        private void defaultInstance(){
            locale = Locale.getDefault();
            rb = ResourceBundle.getBundle(path,locale);
        }

        static GetStr getInstance(){
            if(instance == null){
                instance = new GetStr();
            }
            return instance;
        }

        String getString(String name){
            return  rb.getString(name);
        }

        void   setLocale(Locale locale){
            this.locale = locale;
            rb = ResourceBundle.getBundle(path,locale);
        }

}
