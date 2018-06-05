package by.it.shumilov.Calc;

import java.util.Locale;
import java.util.ResourceBundle;

class GetStr {
        private static GetStr instance;
        String path = "by.it.shumilov.Calc.lang.language";
        private Locale locale = Locale.getDefault();
        private ResourceBundle rb = ResourceBundle.getBundle(path,locale);

        private GetStr(){}

        static GetStr getInstance(){
            if(instance == null){
                instance = new GetStr();
            }
            return instance;
        }

        String getName(String name){
            return  rb.getString(name);
        }

        void   setLocale(Locale locale){
            this.locale = locale;
            rb = ResourceBundle.getBundle(path,locale);
        }

}
