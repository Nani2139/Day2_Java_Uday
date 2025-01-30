package org.example;
import org.example.StudentUtil;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        int[] studentIdList = {1001, 1002};
        List<List<Character>> studentsGrades = new ArrayList<>();
        studentsGrades.add(Arrays.asList('A', 'A', 'A', 'B'));
        studentsGrades.add(Arrays.asList('A', 'B', 'B'));
        List<Double> gpaResults = StudentUtil.calculateGPA(studentIdList, studentsGrades);
        System.out.println("GPA Results: " + gpaResults);
        List<Integer> filteredStudents = StudentUtil.getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);
        System.out.println("Students in GPA range: " + filteredStudents);
    }
}