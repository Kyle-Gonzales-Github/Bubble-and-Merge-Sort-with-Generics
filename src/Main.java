import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.Student;
import sorting.Sort;

public class Main {

    //Float and Double work as inteded, but do not have a range do to Java JDK being changed.

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> ArrayList<Student<T>> createRandomArray(int arrayLength, String typeName) {
        ArrayList<Student<T>> arrayList = new ArrayList<>(arrayLength);
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            String id = String.valueOf(i);
            switch (typeName) {
                case "Integer":
                arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                break;
                case "Float":
                arrayList.add((Student<T>) new Student<Float>(id, random.nextFloat()));
                break;
                case "Double":
                arrayList.add((Student<T>) new Student<Double>(id, random.nextDouble()));
                break;
                default:
                System.out.println("Use integer as a grade data type.");
                arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
            }
        }
        return arrayList;
    }

    public static <T extends Comparable<T>> void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.println("Please input an array length.");
        int arrayLength = scanner.nextInt();
        System.out.println("Please input the grade data type. (Choose Integer, Float, or Double)");
        String typeName = scanner.next();
        ArrayList<Student<T>> arrayList = createRandomArray(arrayLength, typeName);
        System.out.println(arrayList.toString());
        System.out.println(Sort.isSorted(arrayList));
        Sort.mergeSort(arrayList);
        System.out.println(arrayList.toString());
        System.out.println(Sort.isSorted(arrayList));

        System.out.println("Continue? Please enter yes or no");
        String answer=  scanner.next();
        if (answer.equals("no")) break;
        }
        scanner.close();
    }
}
