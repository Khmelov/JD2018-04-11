package by.it.rogov.jd01_01;

public class Args {

    private String[] args;

    Args(String[] args){

        this.args = args;
    }

        void printArgs(){

            int i = 1;
            for (String ar : args){

                i++;
                System.out.println("Аргумент" + i + "=" + ar);
            }

        }
}
