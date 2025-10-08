import java.util.Scanner;
public class Lab3_Q2{
    public static void main(String[] args){
    boolean deny = false;
    String message0 = "The applicant is approved for the credit card.";
    String message1="";String message2="";String message3="";String message4="";String message5="";String message6="";
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter the applicant's age: ");
    int age = sc.nextInt();
    
    System.out.print("Enter the applicant's annual income: ");
    double income = sc.nextDouble();
    
    System.out.print("Enter the applicant's credit score: ");
    int creditScore = sc.nextInt();
   
    System.out.print("Enter the number of existing credit cards: ");
    int numOfCards = sc.nextInt();
    
    System.out.print("Enter the monthly rent/mortgage payment: ");
    double rent = sc.nextDouble();
    double baseEligibility = 100;
    double eligibility = baseEligibility;


    if(age < 18){ 
         deny = true;  
        message2= "The applicant's age must be at least 18.";}
    else if ( age < 25) {
        eligibility += 10;    
    }
    else if (age < 35) {
        eligibility += 20;
    }
    else if (age < 50) {
        eligibility += 25;
    }
    else if (age < 65) {
        eligibility += 15;
    }

    if(income < 15000){ 
        deny = true;  
        message3= "The applicant's annual income must be at least $15,000.";
    }
    else{
        double incomeBonus = 5 * (int)(income/10000);
        if (incomeBonus > 200){incomeBonus = 200;}
        eligibility += incomeBonus;
    }
//For credit score: Add 0 points if score is 300-579, add 50 points if score is 580-669, add 100 points if score is 670-739, add 150 points if score is 740-799, add 200 points if score is 800-850.
     if(creditScore < 580){ 
        deny = true;  
        message4= "The applicant's credit score must be at least 580.";}
    else if(creditScore < 670){ 
        eligibility +=50;}
    else if(creditScore < 740){ 
        eligibility +=100;}
    else if(creditScore < 800){ 
        eligibility +=150;}
    else if(creditScore <= 850){ 
        eligibility +=200;}


    if(numOfCards > 5){ 
        message5= "The applicant's number of existing credit cards must not exceed 5.";
        deny = true;    
    }
    else {
        eligibility -= 10 * numOfCards;
    }

    eligibility -= 5 * (int)(rent/500);

    if(eligibility < 250){ 
        deny = true;  
        message6= "The applicant's calculated eligibility score must be at least 250.";}

    System.out.println("Total eligibility score: "+(int)eligibility);
    if(deny){
        System.out.println("The applicant is not approved for the credit card. Reason:");
        System.out.printf("%s %n %s %n %s %n %s %n %s %n", message2, message3, message4, message5, message6);
    }
    else{
        System.out.println(message0);
    }

     sc.close();
    }
}