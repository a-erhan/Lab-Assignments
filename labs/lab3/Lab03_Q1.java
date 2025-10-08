import java.util.Scanner;
public class Lab03_Q1 {
    public static void main(String[] args) {
        //We will use scanner to take input
        Scanner sc = new Scanner(System.in);
        //Midterm grade
        System.out.print("Enter your midterm score: ");
        //Final grade
        double midtermExam = sc.nextDouble();
        System.out.print("Enter your final exam score: ");
        double finalExam = sc.nextDouble(); 

        //Calculating the average
        double average = 0.4 * midtermExam + 0.6 * finalExam;  
        System.out.printf("Your average is: %.2f%n",average);
        //Calculating the letter grade
        String grade;
        String message;
        if (finalExam < 50){
            grade = "FF";
            message = "You failed the course due to insufficient final exam score.";
        }    
        else if (average < 50){
            grade="FF";
            message = "You failed the course.";
        }
        else if(average < 60){
            grade = "DD";
            message = "You passed the course successfully. Congratulations!";
        }
        else if(average < 70){
            grade = "DC";
            message = "You passed the course successfully. Congratulations!";
        }
        else if(average < 75){
            grade = "CC";
            message = "You passed the course successfully. Congratulations!";
        }
        else if(average < 80){
            grade = "CB";
            message = "You passed the course successfully. Congratulations!";
        }
        else if(average < 85){
            grade = "BB";
            message = "You passed the course successfully. Congratulations!";
        }
        else if(average < 90){
            grade = "BA";
            message = "You passed the course successfully. Congratulations!";
        }
        else {
            grade = "AA";
            message = "You passed the course successfully. Congratulations!";
        }
        System.out.printf("Your letter grade is: %s%n",grade);
        System.out.println(message);
        
    }
}
