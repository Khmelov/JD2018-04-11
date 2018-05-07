package by.it.akhmelev.jd01_01;

public class Hello {
    private String slogan="Hello world";

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    void printSlogan(){
        System.out.println(slogan);
    }
}
