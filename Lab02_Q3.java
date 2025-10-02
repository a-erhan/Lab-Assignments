import java.util.Scanner;
public class Lab02_Q3 {
    public static void main(String[] arguments){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student information: ");
        String input = sc.nextLine();
        input += "&";
        //Sample input: John #Doe / CTIS- Bilkent# 20:15
        int index1 = input.indexOf('#');
        
        String firstName = input.substring(0,index1);
        firstName= firstName.trim();
        int index2 = input.indexOf('/');
        String lastName = input.substring(index1+1, index2);
        lastName = lastName.trim();
        int index3 = input.indexOf('-');
        String department = input.substring(index2+1, index3);
        department = department.trim();
        int index4 = input.indexOf('#', index1+1);
        String university = input.substring(index3+1, index4);
        university = university.trim();
        int index5 = input.indexOf(':');
        String hours = input.substring(index4+1, index5);
        hours = hours.trim();
        int index6 = input.indexOf('&');
        String minutes = input.substring(index5+1, index6);
        minutes = minutes.trim();
        

        System.out.printf("%s %s registered to %s %s at %s past %s.%n",firstName,lastName,university,department,minutes,hours);

        sc.close();
    }
    
}
