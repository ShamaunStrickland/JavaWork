import java.util.Scanner; // allows use of scanner
import java.text.DecimalFormat; // allows use of decimal formatting

public class StudentGradeAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStudents = 3;
        // Instead of having to type multiple data types, you can simply apply [] after the data type to create an array.
        String[] names = new String[numStudents];
        int[] ids = new int[numStudents];
        double[] scores = new double[numStudents];

        // This section allows for the input of the students details. This loop will continue as long as i is less than the numStudents variable which is 3
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":"); // The plus one prevents it from starting at 0.
            System.out.print("Name: ");
            names[i] = scanner.next(); // [i] simply means to store this in the array of data allowing for multiple data entries on the same variable. This lowers redundancy this applies for the below inputs
            System.out.print("ID: ");
            ids[i] = scanner.nextInt();
            System.out.print("Test Score: ");
            scores[i] = scanner.nextDouble();
        }

        // This part Finds the highest and lowest scores
        double highestScore = scores[0];
        double lowestScore = scores[0];

        for (int i = 1; i < numStudents; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
            }

            if (scores[i] < lowestScore) {
                lowestScore = scores[i];
            }
        }

        // This part will calculate average score
        double totalScore = 0;
        for (int i = 0; i < numStudents; i++) {
            totalScore += scores[i];
        }
        // This section i added to stop the computer from doing run on decimals. Using a decimal format util, the pc will only round to two decimals
        double averageScore = totalScore / numStudents;
        DecimalFormat df = new DecimalFormat("0.00");
        String formattedAverageScore = df.format(averageScore);

        // This part simply displays results
        System.out.println("Grade Analysis:");
        System.out.println("Highest Score: " + highestScore);
        System.out.println("Lowest Score: " + lowestScore);
        System.out.println("Average Score: " + formattedAverageScore); // This forces the pc to round to 2 decimal places

        System.out.println("Student Details:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Name: " + names[i]);
            System.out.println("ID: " + ids[i]);
            System.out.println("Score: " + scores[i]);
            System.out.println("Grade: " + calculateGrade(scores[i]));
            System.out.println();
        }
    }

    public static String calculateGrade(double score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
