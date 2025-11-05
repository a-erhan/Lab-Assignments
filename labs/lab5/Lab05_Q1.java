package lab5;

import java.util.Scanner;

public class Lab05_Q1{
    static char toLower(char ch){
        if( 96<ch && ch<123 ){
            return ch;}
        else if( 64<ch && ch<91){
            return (char)((int)ch+32);
            }
        else{return ch;}

    } 
    static boolean isLetter(char ch){
        if(( 'A'<=ch && ch<='Z' )||( 'a'<=ch && ch<='z' )){return true;}
        else{return false;}
    }
    static boolean isDigit(char ch){
        if( '0'<=ch && ch<='9' ){return true;}
        else{return false;}
    }
    static boolean isWhiteSpace(char ch){
        if(ch == ' '||ch == '\t'||ch == '\n'){return true;}
        else{return false;}
    }
    public static boolean isPalindrome(String str){
        int length = str.length();
        String refinedString = "";
        for (int i = 0; i < length; i++) {
            if(!isWhiteSpace(str.charAt(i))){
                refinedString+=str.charAt(i);
            }
        }
        boolean result = true;
        for (int i = 0; i < refinedString.length()/2; i++) {
            if(!(toLower(refinedString.charAt(i))==toLower(refinedString.charAt(refinedString.length()-i-1)))){
                result = false;
            }
  
        }
        return result;
    }
    public static int wordCount(String str){
        String refinedString = str.trim();
        int length = refinedString.length();
        int wordNum = 1;
        for (int i = 0; i < length; i++) {
            char currentCharacter = refinedString.charAt(i);
            if(isWhiteSpace(currentCharacter)){
                wordNum++;
            }
        }
        return wordNum;

    }
    public static boolean areAnagrams(String strOne, String strTwo) {
    if (strOne.length() != strTwo.length()) return false;

    String temp = "";
    for (int i = 0; i < strTwo.length(); i++) {
        temp+=toLower(strTwo.charAt(i));
    } 
    String str1 = "";
    for (int i = 0; i < strOne.length(); i++) {
        str1+=toLower(strOne.charAt(i));
    } 


    for (int i = 0; i < strOne.length(); i++) {
        char ch = toLower(str1.charAt(i)); 
        int index = temp.indexOf(ch); 
        if (index != -1) {
            temp = temp.substring(0, index) + temp.substring(index + 1);
        } else {
            return false;
        }
    }
    return temp.length() == 0;
    }

    public static String slugify(String str){
        StringBuilder sb = new StringBuilder("");
        for (int idx = 0; idx < str.length(); idx++) {
            char currentCharacter = toLower(str.charAt(idx));
            if(isLetter(currentCharacter) || isDigit(currentCharacter)){
                sb.append(currentCharacter);
            }
            else if(isWhiteSpace(currentCharacter)){
                if(sb.length() > 0 && (sb.charAt(sb.length() - 1)!= '-')){
                    sb.append('-');
                }
            }           
        }
        String result = "";
        if(sb.charAt(sb.length()-1)== '-'){
            result = sb.substring(0,sb.length()-1);
        }
        else{
            result = sb.toString();
        }
        return result;
    }
    
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Text toolkit ===");
        System.out.println("1) Check Palindrome");
        System.out.println("2) Check Anagrams");
        System.out.println("3) Word Count");
        System.out.println("4) Slugify");
        System.out.println("5) Exit");
        System.out.print("Select an option (1-5): ");
        int operation = sc.nextInt();
        sc.nextLine();
        if(operation == 1){
            System.out.print("Enter text to check for palindrome: ");
            String str = sc.nextLine();
            if(isPalindrome(str)){
                System.out.printf("'%s' is a palindrome.%n", str);}
            else{
                System.out.printf("'%s' is not a palindrome.%n", str);
            }
        }
        else if (operation == 2) {
            System.out.print("Enter first string: ");
            String str1 = sc.nextLine();
            System.out.print("Enter second string: ");
            String str2 = sc.nextLine();
            if(areAnagrams(str1, str2)){
                System.out.printf("'%s' and '%s' are angrams.%n", str1, str2);}
            else{
                System.out.printf("'%s' and '%s' are not angrams.%n", str1, str2);
            }
        }
        else if (operation == 3) {
            System.out.print("Enter text to count words: ");
            String str = sc.nextLine();
            System.out.println("Word count: " + wordCount(str));
        }
        else if (operation == 4) {
            System.out.print("Enter text to slugify: ");
            String str = sc.nextLine();
            System.out.println("Slug: "+ slugify(str));
        }
        else if (operation == 5) {
            System.out.println("Goodbye");
        }
        else{
            System.out.println("No operation found");
            main(args);
        }
    }
}