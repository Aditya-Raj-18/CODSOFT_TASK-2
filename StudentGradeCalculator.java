import java.util.Scanner;

/**
 * Calculates a student's total marks, average percentage, and grade.
 */
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade Calculator ===");
        int subjectCount = readPositiveInteger(scanner, "Enter the number of subjects: ");
        double totalMarks = 0;

        for (int subject = 1; subject <= subjectCount; subject++) {
            totalMarks += readMark(scanner, "Enter marks for subject " + subject + " (0-100): ");
        }

        double averagePercentage = totalMarks / subjectCount;
        String grade = calculateGrade(averagePercentage);

        System.out.println("\n=== Result ===");
        System.out.printf("Total Marks: %.2f out of %d%n", totalMarks, subjectCount * 100);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static int readPositiveInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value > 0) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println("Please enter a positive whole number.");
        }
    }

    private static double readMark(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double mark = scanner.nextDouble();
                if (mark >= 0 && mark <= 100) {
                    return mark;
                }
            } else {
                scanner.next();
            }
            System.out.println("Marks must be a number from 0 to 100.");
        }
    }

    private static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }
}
