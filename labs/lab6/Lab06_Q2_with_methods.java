import java.util.ArrayList;
import java.util.Scanner;

public class Lab06_Q2_with_methods {

    static Scanner sc = new Scanner(System.in);
    static int initTask;
    static int actualSize = 0;
    static String [] taskNames ;
    static int[] priorities;
    static boolean isCont = true;
    static ArrayList<String> taskNamesDynamic = new ArrayList<>();
    static ArrayList<Integer> prioritiesDynamic = new ArrayList<>();
    static boolean usingArrayList = false;

    public static void main(String[] args) {
        System.out.print("Enter initial task capacity: ");
        initTask = sc.nextInt();
        
        taskNames = new String[initTask];
        priorities = new int[initTask];
        
        while(isCont){
            System.out.println("=== Task Scheduler ===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Update Task Priority");
            System.out.println("4. Search Task");
            System.out.println("5. View All Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = sc.nextInt();
            sc.nextLine();
            //Clear the reamaining symbols

            if(option == 1){
                System.out.print("Enter task name: ");
                String taskName = sc.nextLine();
                if(taskName.equals("")){
                    System.out.println("The task name can't be an empty string.");
                }
                else if((usingArrayList && taskNamesDynamic.contains(taskName))||(!usingArrayList && containsArray(taskNames, taskName))){
                    System.out.println("This task name is currently in-use. Choose another one.");
                }
                else{
                    System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                    int priority = sc.nextInt();
                    if(priority < 1 || priority > 3){
                        System.out.println("No such priority. Enter a valid priority between 1 and 3");
                    }
                    else{
                        addTask(taskName, priority); 
                    }
                }
            }
            else if(option == 2){
                System.out.print("Enter the task name to remove: ");
                String taskName = sc.next();
                removeTask(taskName);
            }
            else if(option == 3){
                System.out.print("Enter the task name to update: ");
                String taskName = sc.next();
                updateTaskPriority(taskName); 
            }
            else if(option == 4){
                System.out.print("Enter task name to search: ");
                String taskName = sc.next();
                searchTask(taskName);
            }
            else if(option == 5){
                viewAllTasks();
            }
            else if(option == 6){
                exit();
            }
            else{
                System.out.println("Invalid operation");
            }
        }
    }

    public static void addTask(String taskName, int priority) {
        if(actualSize < initTask){
            taskNames[actualSize] = taskName;
            priorities[actualSize] = priority;
            actualSize++;
            System.out.println("Task added successfully!");
        }
        else{
            if(actualSize == taskNames.length){
                System.out.println("Array full! Switching to dynamic ArrayList...");
                usingArrayList = true;
                for ( int idx = 0; idx < initTask; idx++) {
                    taskNamesDynamic.add(taskNames[idx]);
                    prioritiesDynamic.add(priorities[idx]);
                }
            }
            taskNamesDynamic.add(taskName);
            prioritiesDynamic.add(priority);
            actualSize = taskNamesDynamic.size();
            System.out.println("Task added successfully!");
        }
    }

    public static void removeTask(String taskName) {
        if(usingArrayList){
            int index = taskNamesDynamic.indexOf(taskName);
            if(index >= 0){
                taskNamesDynamic.remove(index);
                prioritiesDynamic.remove(index);
            }
            else{
                System.out.println("Task not found!");
            }
        }else{
            String[] tempNames = new String[taskNames.length-1];
            int[] tempPriorites = new int[taskNames.length -1];
            int idxTemp = 0;
            for (int idx = 0; idx < taskNames.length; idx++) {
                if(!taskNames[idx].equals(taskName)){
                    tempNames[idxTemp] = taskNames[idx];
                    tempPriorites[idxTemp] = priorities[idx];
                    idxTemp++;
                }   
            }
            taskNames = tempNames;
            priorities = tempPriorites;
            actualSize--;
            System.out.println("Task removed successfully.");
        }
    }

    public static void updateTaskPriority(String taskName) {
        if(usingArrayList){                    
            int index = taskNamesDynamic.indexOf(taskName);
            System.out.println("Current priority :" + prioritiesDynamic.get(index));
            boolean tryagain = false;
            do {                         
            System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
            int newPriority = sc.nextInt();
            if(newPriority == prioritiesDynamic.get(index)){
                System.out.println("New priority cannot be the same as the current priority. Try again.");
                tryagain = true;
            }
            else{
            prioritiesDynamic.set(index, newPriority);
            tryagain = false;
            }
        }while (!tryagain);
        }else{   
            int idxOfTask = -1;                 
            for (int idx = 0; idx < taskNames.length; idx++) {
                if(taskNames[idx].equals(taskName)){
                    idxOfTask = idx;
                }
            }
            boolean tryagain = false;
            do {                         
                System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                int newPriority = sc.nextInt();
                if(newPriority == priorities[idxOfTask]){
                    System.out.println("New priority cannot be the same as the current priority. Try again.");
                    tryagain = true;
                }
                else{
                    priorities[idxOfTask] = newPriority; 
                    tryagain = false;
                }
            }while (!tryagain);
            
        }
        System.out.println("Priority updated!");
    }

    public static void searchTask(String taskName) {
        if(usingArrayList){  
            boolean isContains = taskNamesDynamic.contains(taskName);
            if(isContains){
                int idxTask = taskNamesDynamic.indexOf(taskName);
                System.out.printf("Task found! Priority( %d)%n", prioritiesDynamic.get(idxTask));
            }
            else{
                System.out.println("Task not found!");
            }
        }else{  
            boolean taskfound = false;
            for (int i = 0; i < taskNames.length; i++) {
               if(taskNames[i].equals(taskName)){
                System.out.printf("Task found! Priority( %d)%n", priorities[i]);
                taskfound = true;
                break;
               }
            }
            if(!taskfound){
            System.out.println("Task not found!");
            }
             
        }
    }

    public static void viewAllTasks() {
        if(usingArrayList){  
            for (int i = 1; i <= taskNamesDynamic.size(); i++) {
               System.out.println(i + ". "+taskNamesDynamic.get(i-1)+ "(Priority "+prioritiesDynamic.get(i-1)+")"); 
            }                  
            
        }else{   
            if(actualSize == 0){
                System.out.println("No tasks to display.");
            }
            else{
                for (int i = 1; i <= actualSize; i++) {
                System.out.println(i + ". "+taskNames[i-1]+ "(Priority "+priorities[i-1]+")"); 
                } 
            }
        }
    }

    public static void exit() {
        System.out.println("Quit!");
        isCont = false;
    }

    public static boolean containsArray(String[] arr, String str){
        if(actualSize == 0){
            return false;
        }
        for(int idx = 0; idx < arr.length; idx++){
            if(arr[idx].equals(str)){
                return true;
            }
        }
        return false;
    }
}