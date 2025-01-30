package org.example;
import java.util.ArrayList;
import java.util.List;
public class StudentUtil {
    //Method to Calculate GPA for every ID(Student)
    public static List<Double> calculateGPA(int[] studentIdList, List<List<Character>> studentsGrades) {
        //gpaArray list is storing GPA of every individual.
        List<Double> gpaArray = new ArrayList<>();
        //iterating through the studentID array i.e calculating for every student
        for (int i = 0; i < studentIdList.length; i++) {
            // totalPoints variable will store total score for every individual
            int totalPoints = 0;
            //numCourses will store number of subjects every individual student studied
            int numCourses = studentsGrades.get(i).size();
            // iterating through the  StudentGrades 2D array to calculate the points
            for (char grade : studentsGrades.get(i)) {
                totalPoints += getGradePoints(grade);
            }
            //storing GPA of every individual
            gpaArray.add((double) totalPoints / numCourses);
        }
        return gpaArray;
}

public static List<Integer> getStudentsByGPA(double lower, double higher, int[] studentIdList, List<List<Character>> studentsGrades) {
        //checking for out of bounds;
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }
        // same here we get that GPA array from above method
        List<Double> gpaArray = calculateGPA(studentIdList, studentsGrades);
        // this list stores studentID's after following our condition lower<=GPA<=higher
        List<Integer> filteredStudents = new ArrayList<>();
        //iterating through the gpa array
        for (int i = 0; i < gpaArray.size(); i++) {
            //checking for condition
            if (gpaArray.get(i) >= lower && gpaArray.get(i) <= higher) {
                filteredStudents.add(studentIdList[i]);
            }
        }
        return filteredStudents;
    }
    //method for returning those grades
    private static int getGradePoints(char grade) {
        if(grade == 'A') return 4;
        else if(grade == 'B') return 3;
        else if(grade == 'C') return 2;
        else throw new IllegalArgumentException("Invalid Grade:"+grade+"Try to input appropriate grade");
    }
}


