package by.it.obmetko.jd01_07;


class Vector extends AbstractVar {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String str) {
        String s = str.substring(1,str.length()-1);
        String[] strMas = s.split(",");
        this.value = new double[strMas.length];
        for (int i = 0; i <strMas.length ; i++) {
            value[i] = Double.parseDouble(strMas[i]);
        }

        }

        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder("{");
            String delimiter = "";
            for (double element : value) {
                sb.append(delimiter).append(element);
                delimiter = ", ";
            }
            sb.append("}");
            return sb.toString();
        }
    }

