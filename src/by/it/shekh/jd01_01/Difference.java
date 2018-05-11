package by.it.shekh.jd01_01;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
    private int[] elements;
    public int maximumDifference;
    Difference(int []elements){
        this.elements=new int[elements.length];
        for(int i=0;i<elements.length;i++)
            this.elements[i]=elements[i];
    }

    int computeDifference(){
        for(int i=0;i<this.elements.length-1;i++)
            for(int j=i+1;j<this.elements.length;j++)
                if(Math.abs(this.elements[i]-this.elements[j])>maximumDifference)
                    maximumDifference=Math.abs(this.elements[i]-this.elements[j]);
        return maximumDifference;
    }
}
