//package by.it.rogov.jd01_04;
//
//import java.util.Scanner;
//
//public class TaskC {
//
//    static void buildOneDimArray(String line){
//        double[] array=InOut.getArray(line);
//        InOut.printArray(array,"V",5);
//        double first= array[0];
//        double last= array[array.length-1];
//        mergeSort(array);
//        InOut.printArray(array,"V",5);
//        for (int i = 0; i < array.length; i++) {
//            if(array[i]== first){
//                System.out.println("Index of first element=" + i);
//                break;
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            if(array[i]== last){
//                System.out.println("Index of last element="+ i);
//                break;
//            }
//        }
//
//    }
//
//
//    static void mergeSort(double[ ] array){
//
//      merge(mergeSort(),mergeSort())
//
//
//
//    }
//
//    private static double[ ] mergeSort(double[ ] array, int left, int right){
//        if (left<right){
//            int s;
//            s = (left+right)/2;
//            double[]array1=new double[];
//            for (int i = 0; i < array1.length; i++) {
//                array1[i]=array[i]
//            }
//            return merge(mergeSort(array1,left,s),mergeSort(array2,s+1,right))
//
//        }
//
//    }
//
//    private static double[] merge(double[] part1, double[] part2){
//        double[] array= new double[part1.length+part2.length];
//        int i=0,j=0;
//        for (int i1 = 0; i1 < part1.length + part2.length; i1++) {
//            if(i1>=part1.length+1&&i1>=part2.length+1){
//
//              return array;
//
//        }else if(i1==part1.length+1){
//                array[i1]=part2[j];
//                j++;
//            }else if(i1==part2.length+1){
//                array[i1]=part1[i];
//                i++;
//            }else if(part1[i]==part2[j]){
//                array[i1]=part1[i];
//                array[i1+1]=part2[j];
//                i++;
//                j++;
//            }else if(part1[i]>part2[j]){
//                array[i1]=part1[i];
//                i++;
//            }else{
//                array[i1]=part2[j];
//                j++;
//            }
//
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        buildOneDimArray(line);
//    }
//}
