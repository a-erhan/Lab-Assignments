import java.util.ArrayList;
import java.util.Scanner;

public class Lab06_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial task capacity: ");
        int initTask = sc.nextInt();
        int actualSize = 0;
        String [] tasknames = new String[initTask];
        int[] priorities = new int[initTask];
        boolean isCont = true;
        ArrayList<String> taskNamesDynamic = new ArrayList<>();
        ArrayList<Integer> prioritiesDynamic = new ArrayList<>();
        boolean usingArrayList = false;

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

            if(option == 1){
                System.out.print("Enter task name: ");
                String taskName = sc.next();
                System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                int priority = sc.nextInt();
                if(actualSize < initTask){
                    tasknames[actualSize] = taskName;
                    priorities[actualSize] = priority;
                    actualSize++;
                }
                else{
                    if(actualSize == tasknames.length){
                        System.out.println("Array full! Switching to dynamic ArrayList...");
                        usingArrayList = true;
                        for ( int idx = 0; idx < initTask; idx++) {
                            taskNamesDynamic.add(tasknames[idx]);
                            prioritiesDynamic.add(priorities[idx]);
                        }
                    }
                    taskNamesDynamic.add(taskName);
                    prioritiesDynamic.add(priority);
                    actualSize = taskNamesDynamic.size();
                    System.out.println("Task added successfully!");
                }
                

            }
            else if(option == 2){
                System.out.print("Enter the task name to remove: ");
                String taskName = sc.next();
                if(usingArrayList){
                    int index = taskNamesDynamic.indexOf(taskName);
                    taskNamesDynamic.remove(index);
                    prioritiesDynamic.remove(index);
                }else{
                    String[] tempNames = new String[tasknames.length-1];
                    int[] tempPriorites = new int[tasknames.length -1];
                    int idxTemp = 0;
                    for (int idx = 0; idx < tasknames.length; idx++) {
                        if(!tasknames[idx].equals(taskName)){
                            tempNames[idxTemp] = tasknames[idx];
                            tempPriorites[idxTemp] = priorities[idx];
                            idxTemp++;
                        }   
                    }
                    tasknames = tempNames;
                    priorities = tempPriorites;
                    actualSize--;
                    System.out.println("Task removed successfully.");
                }
                
            }
            else if(option == 3){
                System.out.print("Enter the task name to update: ");
                String taskName = sc.next();
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
                    for (int idx = 0; idx < tasknames.length; idx++) {
                        if(tasknames[idx].equals(taskName)){
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
            else if(option == 4){
                System.out.print("Enter task name to search: ");
                String taskName = sc.next();
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
                    for (int i = 0; i < tasknames.length; i++) {
                       if(tasknames[i].equals(taskName)){
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
            else if(option == 5){
                if(usingArrayList){  
                    for (int i = 1; i <= taskNamesDynamic.size(); i++) {
                       System.out.println(i + ". "+taskNamesDynamic.get(i-1)+ "(Priority "+prioritiesDynamic.get(i-1)+")"); 
                    }                  
                    
                }else{   
                    for (int i = 1; i <= actualSize; i++) {
                       System.out.println(i + ". "+tasknames[i-1]+ "(Priority "+priorities[i-1]+")"); 
                    } 
                }
            }
            else if(option == 6){
                System.out.println("Quit!");
                isCont = false;
            }
            else{
                System.out.println("Invalid operation");
            }

        }
    }
}