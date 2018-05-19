package by.it.zaliashchonak.my_tests;

/**
 * Created by Andrey on 12.05.2018.
 */
public class DemoAnonimous {
    static class People{
        private String name;
        public People (String name){
            this.name=name;
        }
        public String toString(){
            return name;
        }
        public void print (){
            System.out.println("Второй метод");
        }
    }

    public static void main(String[] args) {
        People mother = new People("Veronika");
        People father = new People("Alex");
        People son = new People("Serg");
        People ano = new People("Noname"){
            public void print (){
                System.out.println("Изменил метод");
            }
        };
        System.out.println(mother);
        System.out.println(father);
        System.out.println(son);
        System.out.println(ano);
        //System.out.println();
        ano.print();

    }
}
