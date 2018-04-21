package by.it.krivenkova.jd01_01;

public class Args {

    private  String[] args;

    Args(String[] args){
        this.args = args;
    }

    void printArgs(){
        int i = 1;
        for (String arg: args){
            //   System.out.println("i:" + i);
            i = i + 1;
            System.out.println("Аргумент " + i + "=" + arg);
        }
    }

   /* void showArgs(String[] ar){
        for (String a : ar) {
            System.out.println(a);
        }
    }*/
}
