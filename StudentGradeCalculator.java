import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student details
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();

        // Input number of subjects
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();

        String[] subjects = new String[numSubjects];
        int[] marks = new int[numSubjects];
        int total = 0;

        // Input subject names and marks
        for (int i = 0; i < numSubjects; i++) {
            scanner.nextLine(); // consume newline
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();

            System.out.print("Enter marks for " + subjects[i] + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Add to total
            total += marks[i];
        }

        // Calculate percentage
        double percentage = (double) total / numSubjects;

        // Calculate grade
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B+";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else if (percentage >= 40) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Output result
        System.out.println("\n--- Student Report ---");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("\nSubject-wise Marks:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.println("\nTotal Marks : " + total + "/" + (numSubjects * 100));
        System.out.printf("Percentage  : %.2f%%\n", percentage);
        System.out.println("Grade       : " + grade);

        scanner.close();
    }
}
