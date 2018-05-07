package by.it.shekh.jd01_01;

public class Count {
    public static void main(String[] args) {
        intCounter();
    }

    static void intCounter() {
        int a = 2, b = 3, c;
        c=+a+b;
        System.out.println("+a+b="+c);
        c=-a+b;
        System.out.println("-a+b="+c);
        c=a/b;
        System.out.println("a/b="+c);
        c=~a;
        System.out.println("a="+Integer.toBinaryString(a)+"\n~a="+Integer.toBinaryString(c));
        c=a++;
        System.out.println("a++="+c);
        c=++a+b;
        System.out.println("++a+b="+c);
        c=a<<2;
        System.out.println("a<<2="+c+Integer.toBinaryString(c));
        c=a%b;
        System.out.println("a%b="+c);
        c=a&b;
        System.out.println("Побитовое И a&b="+Integer.toBinaryString(a)+"->a "+Integer.toBinaryString(b)+"->b"+" "+Integer.toBinaryString(c)+"->c");
        c=a|b;
        System.out.println("Побитовое ИЛИ a|b="+Integer.toBinaryString(a)+"->a "+Integer.toBinaryString(b)+"->b"+" "+Integer.toBinaryString(c)+"->c");
        c=a^b;
        System.out.println("Побитовое исключающее ИЛИ a^b="+Integer.toBinaryString(a)+"->a "+Integer.toBinaryString(b)+"->b"+" "+Integer.toBinaryString(c)+"->c");


    }
}
