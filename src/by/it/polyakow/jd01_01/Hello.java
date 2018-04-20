package by.it.polyakow.jd01_01;

public class Hello {
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    private String slogan = "Hello world";
    //public void setSlogan(String slogan);

    void printSlogan () {
        System.out.println(slogan);
    }
}
