import java.util.InputMismatchException;
import java.util.Scanner;
public class STUDENT_GRADE_CALCULATOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner obj=new Scanner(System.in);
System.out.print("Enter number of subjects: ");
int n=obj.nextInt();
double sum=0;
for(int i=1;i<=n;i++) {
	System.out.printf("Enter marks obtain in %d subject out of 100: ",i);
    try {
      double  marks = obj.nextDouble();
      sum = sum + marks;
        if (marks < 0 || marks > 100) {
            System.out.printf("Marks must be between 0 and 100. Please try again.\n");
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a whole number.");
        obj.nextLine();
	 }}
double average=(double)(sum/(n*100))*100;
String grade;
if (average>= 90) {
    grade = "O (OUTSTANDING)";
} else if (average >= 80) {
    grade = "A (VERY GOOD)";
} else if (average >= 70) {
    grade = "B (GOOD)";
} else if (average >= 60) {
    grade = "C (POOR)";
} else if (average >= 50) {
    grade = "D (VERY POOR)";
} else {
    grade = "F (FAIL:BETTER LUCK NEXT TIME)";
}
System.out.println("****Results****");
System.out.printf("Total Marks: %f\n",sum);
System.out.printf("Average Percentage: %.2f%%\n", average);
System.out.println("Grade: " + grade);
obj.close();
  }
}
