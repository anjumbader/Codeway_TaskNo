import java.util.Scanner;
public class GradeCalculator {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the number of subjects:");
            int numOfSubjects = scanner.nextInt();

            int totalMarks = 0;

            System.out.println("Enter marks (out of 100) for each subject:");

            for (int i = 1; i <= numOfSubjects; i++) {
                System.out.print("Subject " + i + ": ");
                int marks = scanner.nextInt();
                totalMarks += marks;
            }

            double averagePercentage = (double) totalMarks / numOfSubjects;

            System.out.println("\nResults:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + calculateGrade(averagePercentage));

            scanner.close();
        }

        private static char calculateGrade(double averagePercentage) {
            if (averagePercentage >= 90) {
                return 'A';
            } else if (averagePercentage >= 80) {
                return 'B';
            } else if (averagePercentage >= 70) {
                return 'C';
            } else if (averagePercentage >= 60) {
                return 'D';
            } else {
                return 'F';
            }
        }
    }


