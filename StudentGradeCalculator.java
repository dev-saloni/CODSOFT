import java.util.*;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberSubjects;
        double TotalMarks = 0;

        System.out.print("Enter the number of subjects: ");
        numberSubjects = sc.nextInt();

        double marks[] = new double[numberSubjects];

        // Take marks obtained in each subject
        for (int i = 0; i < numberSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextDouble();
            TotalMarks += marks[i];
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + TotalMarks);

        // Calculate Average Percentage
        double averagePercentage = (TotalMarks / (numberSubjects * 100)) * 100;
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Grade Calculation
        String grade;
        if (averagePercentage >= 90) 
        {
            grade = "O";
        }else if (averagePercentage >= 80){
            grade = "E";
        } 
        else if (averagePercentage >= 70){
            grade = "A";
        } else if (averagePercentage >= 60){
            grade = "B";
        }else if(averagePercentage >= 50){
            grade = "C";
        }
        else if(averagePercentage >= 40){
            grade="D";}
            else {
                grade="F";
            }

        // Display Results
        System.out.println("Grade: " + grade);
    }
}