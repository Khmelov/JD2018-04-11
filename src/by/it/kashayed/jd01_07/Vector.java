package by.it.kashayed.jd01_07;

public class Vector extends AbstractVar {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        double [] vec = new double[strVector.length()];
        strVector.split(", ");

        for (int i = 0; i < vec.length; i++) {
            vec[i]= strVector.indexOf(i);
        }
        this.value=vec;


    }
  @Override
  public String toString() {
      StringBuilder sb=new StringBuilder("{");
      String delimiter="";
      for (double element : value) {
          sb.append(delimiter).append(element);
          delimiter=", ";
      }
      sb.append('}');
      return sb.toString();
  }

}