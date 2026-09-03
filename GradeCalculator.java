import java.util.Scanner;

public class GradeCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("==============================");

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        double homeworkAverage = getCategoryAverage("Homework");
        double quizAverage = getCategoryAverage("Quizzes");
        double examAverage = getCategoryAverage("Exams");

        double homeworkWeight = 0.30;
        double quizWeight = 0.20;
        double examWeight = 0.50;

        double finalAverage =
                (homeworkAverage * homeworkWeight)
                + (quizAverage * quizWeight)
                + (examAverage * examWeight);

        String letterGrade = getLetterGrade(finalAverage);

        displayResults(
                studentName,
                homeworkAverage,
                quizAverage,
                examAverage,
                finalAverage,
                letterGrade
        );

        scanner.close();
    }

    public static double getCategoryAverage(String category) {

        System.out.println("\n--- " + category + " ---");

        System.out.print(
                "How many " + category.toLowerCase() + " grades do you have? "
        );

        int numberOfGrades = getPositiveInteger();

        double total = 0;

        for (int i = 1; i <= numberOfGrades; i++) {

            System.out.print(
                    "Enter grade " + i + " (0-100): "
            );

            double grade = getValidGrade();

            total += grade;
        }

        return total / numberOfGrades;
    }

    public static double getValidGrade() {

        while (true) {

            try {

                double grade = Double.parseDouble(scanner.nextLine());

                if (grade >= 0 && grade <= 100) {
                    return grade;
                }

                System.out.print(
                        "Grade must be between 0 and 100. Try again: "
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Invalid input. Enter a number between 0 and 100: "
                );
            }
        }
    }

    public static int getPositiveInteger() {

        while (true) {

            try {

                int number = Integer.parseInt(scanner.nextLine());

                if (number > 0) {
                    return number;
                }

                System.out.print(
                        "Enter a number greater than 0: "
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Invalid input. Enter a whole number: "
                );
            }
        }
    }

    public static String getLetterGrade(double average) {

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void displayResults(
            String studentName,
            double homeworkAverage,
            double quizAverage,
            double examAverage,
            double finalAverage,
            String letterGrade) {

        System.out.println("\n==============================");
        System.out.println("         GRADE REPORT");
        System.out.println("==============================");

        System.out.println("Student: " + studentName);

        System.out.printf(
                "Homework Average: %.2f%%%n",
                homeworkAverage
        );

        System.out.printf(
                "Quiz Average: %.2f%%%n",
                quizAverage
        );

        System.out.printf(
                "Exam Average: %.2f%%%n",
                examAverage
        );

        System.out.printf(
                "Final Average: %.2f%%%n",
                finalAverage
        );

        System.out.println("Letter Grade: " + letterGrade);

        System.out.println("==============================");
    }
}
