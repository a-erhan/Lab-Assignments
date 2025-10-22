import java.util.Scanner;
public class Lab04_Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Battleship!");
        System.out.println("The grid is 5x5. There are 5 hidden ships.");
        System.out.println();
        System.out.println("Initial Grid:");
        //Initializing rows
        String rowPlayer0 = "~~~~~";
        String rowPlayer1 = "~~~~~";
        String rowPlayer2 = "~~~~~";
        String rowPlayer3 = "~~~~~";
        String rowPlayer4 = "~~~~~";

        String rowActual0 = "00000";
        String rowActual1 = "00000";
        String rowActual2 = "00000";
        String rowActual3 = "00000";
        String rowActual4 = "00000";

        //Placing ships
        String ships = "";
        int ship1 = (int)Math.round(Math.random() * 24);//round turns to a long
        ships += (ship1 + " ");
        int rowNum = ship1 / 5;
        int columnNum = ship1 % 5;
        switch (rowNum) {
            case 0:
                rowActual0 = rowActual0.substring(0,columnNum)+"1"+rowActual0.substring(columnNum + 1);
                break;
            case 1:
                rowActual1 = rowActual1.substring(0,columnNum)+"1"+rowActual1.substring(columnNum + 1);
                break;
            case 2:
                rowActual2 = rowActual2.substring(0,columnNum)+"1"+rowActual2.substring(columnNum + 1);
                break;
            case 3:
                rowActual3 = rowActual3.substring(0,columnNum)+"1"+rowActual3.substring(columnNum + 1);
                break;
            case 4:
                rowActual4 = rowActual4.substring(0,columnNum)+"1"+rowActual4.substring(columnNum + 1);
                break;
        }
        


        int ship2 = (int)Math.round(Math.random() * 24);//round turns to a long
        while(ships.contains(""+ship2)){
            ship2 = (int)Math.round(Math.random() * 24);
        } 
        ships += (ship2 + " ");
        rowNum = ship2 / 5;
        columnNum = ship2 % 5;
        switch (rowNum) {
            case 0:
                rowActual0 = rowActual0.substring(0,columnNum)+"1"+rowActual0.substring(columnNum + 1);
                break;
            case 1:
                rowActual1 = rowActual1.substring(0,columnNum)+"1"+rowActual1.substring(columnNum + 1);
                break;
            case 2:
                rowActual2 = rowActual2.substring(0,columnNum)+"1"+rowActual2.substring(columnNum + 1);
                break;
            case 3:
                rowActual3 = rowActual3.substring(0,columnNum)+"1"+rowActual3.substring(columnNum + 1);
                break;
            case 4:
                rowActual4 = rowActual4.substring(0,columnNum)+"1"+rowActual4.substring(columnNum + 1);
                break;
        }


        int ship3 = (int)Math.round(Math.random() * 24);//round turns to a long

        
        while(ships.contains(""+ship3)){
            ship3 = (int)Math.round(Math.random() * 24);
        } 
        ships += (ship3 + " ");
        rowNum = ship3 / 5;
        columnNum = ship3 % 5;
        switch (rowNum) {
            case 0:
                rowActual0 = rowActual0.substring(0,columnNum)+"1"+rowActual0.substring(columnNum + 1);
                break;
            case 1:
                rowActual1 = rowActual1.substring(0,columnNum)+"1"+rowActual1.substring(columnNum + 1);
                break;
            case 2:
                rowActual2 = rowActual2.substring(0,columnNum)+"1"+rowActual2.substring(columnNum + 1);
                break;
            case 3:
                rowActual3 = rowActual3.substring(0,columnNum)+"1"+rowActual3.substring(columnNum + 1);
                break;
            case 4:
                rowActual4 = rowActual4.substring(0,columnNum)+"1"+rowActual4.substring(columnNum + 1);
                break;
        }


        int ship4 = (int)Math.round(Math.random() * 24);//round turns to a long
        while(ships.contains(""+ship4)){
            ship4 = (int)Math.round(Math.random() * 24);
        } 
        ships += (ship4 + " ");
        rowNum = ship4 / 5;
        columnNum = ship4 % 5;
        switch (rowNum) {
            case 0:
                rowActual0 = rowActual0.substring(0,columnNum)+"1"+rowActual0.substring(columnNum + 1);
                break;
            case 1:
                rowActual1 = rowActual1.substring(0,columnNum)+"1"+rowActual1.substring(columnNum + 1);
                break;
            case 2:
                rowActual2 = rowActual2.substring(0,columnNum)+"1"+rowActual2.substring(columnNum + 1);
                break;
            case 3:
                rowActual3 = rowActual3.substring(0,columnNum)+"1"+rowActual3.substring(columnNum + 1);
                break;
            case 4:
                rowActual4 = rowActual4.substring(0,columnNum)+"1"+rowActual4.substring(columnNum + 1);
                break;
        }


        int ship5 = (int)Math.round(Math.random() * 24);//round turns to a long
        while(ships.contains(""+ship5)){
            ship5 = (int)Math.round(Math.random() * 24);
        } 

        ships += (ship5 + " ");
        rowNum = ship5 / 5;
        columnNum = ship5 % 5;

        switch (rowNum) {
            case 0:
                rowActual0 = rowActual0.substring(0,columnNum)+"1"+rowActual0.substring(columnNum + 1);
                break;
            case 1:
                rowActual1 = rowActual1.substring(0,columnNum)+"1"+rowActual1.substring(columnNum + 1);
                break;
            case 2:
                rowActual2 = rowActual2.substring(0,columnNum)+"1"+rowActual2.substring(columnNum + 1);
                break;
            case 3:
                rowActual3 = rowActual3.substring(0,columnNum)+"1"+rowActual3.substring(columnNum + 1);
                break;
            case 4:
                rowActual4 = rowActual4.substring(0,columnNum)+"1"+rowActual4.substring(columnNum + 1);
                break;
        }
        //System.out.printf("%s%n%s%n%s%n%s%n%s%n",rowActual0,rowActual1,rowActual2,rowActual3,rowActual4);

        
        
        // The game loop starts here
        int currentPlayer = 0;
        int pointPlayerZero = 0;
        int pointPlayerOne = 0;
        int pointPlayerTwo = 0;
        int totalHit = 0;
        int totalGuesses = 0;
        double rounds = 1;
        String guesses = "";


        do{
                rounds+=1.0/3;
                System.out.println("###### Round #"+(int)rounds);

                //determining the player
                if(currentPlayer == 0){System.out.println("## Player1 ##");}
                else if(currentPlayer == 1){System.out.println("## Player2 ##");}
                else{System.out.println("## Player3 ##");}
                
                System.out.println("Previous Grid:");
                //print the current grid
                for(int count=0; count < rowPlayer0.length(); count++){
                    System.out.print(rowPlayer0.charAt(count)+" ");
                }
                System.out.println();
                for(int count=0; count < rowPlayer1.length(); count++){
                    System.out.print(rowPlayer1.charAt(count)+" ");
                }
                System.out.println();
                for(int count=0; count < rowPlayer2.length(); count++){
                    System.out.print(rowPlayer2.charAt(count)+" ");
                }
                System.out.println();
                for(int count=0; count < rowPlayer3.length(); count++){
                    System.out.print(rowPlayer3.charAt(count)+" ");
                }
                System.out.println();
                for(int count=0; count < rowPlayer4.length(); count++){
                    System.out.print(rowPlayer4.charAt(count)+" ");
                }
                System.out.println();

                
                //Taking the guess
            
                        System.out.print("Guess row: ");
                        int rowNumGuess = sc.nextInt();
                        System.out.print("Guess column: ");
                        int columnNumGuess = sc.nextInt();
                        totalGuesses++;

                if(!(rowNumGuess < 0 || rowNumGuess > 4 || columnNumGuess < 0 || columnNumGuess > 4)){
                    if(guesses.contains(""+rowNumGuess+","+columnNumGuess)){System.out.println("Already guessed here!");}
                    else{
                        currentPlayer = (++currentPlayer) % 3;
                        String rowGuess= "";//To silent compiler
                        guesses += ""+ rowNumGuess +","+ columnNumGuess+" ";
                        switch (rowNumGuess) {
                            case 0:
                                rowGuess = rowActual0;
                                if(rowGuess.charAt(columnNumGuess)=='1'){
                                    System.out.println("Hit!");
                                    
                                    rowPlayer0 = rowPlayer0.substring(0,columnNumGuess) + 'X' + rowPlayer0.substring(columnNumGuess + 1);
                                    totalHit++;
                                    if(currentPlayer == 0){
                                        pointPlayerZero++;}
                                    else if(currentPlayer == 1){
                                        pointPlayerOne++;}
                                    else{
                                        System.out.println(pointPlayerTwo++);}
                                }
                                else{
                                    System.out.println("Miss!");
                                    rowPlayer0 = rowPlayer0.substring(0,columnNumGuess) + 'O' + rowPlayer0.substring(columnNumGuess + 1);
                                }
                                break;
                            case 1:
                                rowGuess = rowActual1;
                                if(rowGuess.charAt(columnNumGuess)=='1'){
                                    System.out.println("Hit!");
                                    
                                    rowPlayer1 = rowPlayer1.substring(0,columnNumGuess) + 'X' + rowPlayer1.substring(columnNumGuess + 1);
                                    totalHit++;
                                    if(currentPlayer == 0){
                                        pointPlayerZero++;}
                                    else if(currentPlayer == 1){
                                        pointPlayerOne++;}
                                    else{
                                        System.out.println(pointPlayerTwo++);}
                                }
                                else{
                                    System.out.println("Miss!");
                                    rowPlayer1 = rowPlayer1.substring(0,columnNumGuess) + 'O' + rowPlayer1.substring(columnNumGuess + 1);
                                }
                                break;

                            case 2:
                                rowGuess = rowActual2;
                                if(rowGuess.charAt(columnNumGuess)=='1'){
                                    System.out.println("Hit!");
                                    
                                    rowPlayer2 = rowPlayer2.substring(0,columnNumGuess) + 'X' + rowPlayer2.substring(columnNumGuess + 1);
                                    totalHit++;
                                    if(currentPlayer == 0){
                                        pointPlayerZero++;}
                                    else if(currentPlayer == 1){
                                        pointPlayerOne++;}
                                    else{
                                        System.out.println(pointPlayerTwo++);}
                                }
                                else{
                                    System.out.println("Miss!");
                                    rowPlayer2 = rowPlayer2.substring(0,columnNumGuess) + 'O' + rowPlayer2.substring(columnNumGuess + 1);
                                }
                                break;
                            case 3:
                                rowGuess = rowActual3;
                                if(rowGuess.charAt(columnNumGuess)=='1'){
                                    System.out.println("Hit!");
                                    
                                    rowPlayer3 = rowPlayer3.substring(0,columnNumGuess) + 'X' + rowPlayer3.substring(columnNumGuess + 1);
                                    totalHit++;
                                    if(currentPlayer == 0){
                                        pointPlayerZero++;}
                                    else if(currentPlayer == 1){
                                        pointPlayerOne++;}
                                    else{
                                        System.out.println(pointPlayerTwo++);}
                                }
                                else{
                                    System.out.println("Miss!");
                                    rowPlayer3 = rowPlayer3.substring(0,columnNumGuess) + 'O' + rowPlayer3.substring(columnNumGuess + 1);
                                }
                                break;
                            case 4:
                                rowGuess = rowActual4;
                                if(rowGuess.charAt(columnNumGuess)=='1'){
                                    System.out.println("Hit!");
                                    
                                    rowPlayer4 = rowPlayer4.substring(0,columnNumGuess) + 'X' + rowPlayer4.substring(columnNumGuess + 1);
                                    totalHit++;
                                    if(currentPlayer == 0){
                                        pointPlayerZero++;}
                                    else if(currentPlayer == 1){
                                        pointPlayerOne++;}
                                    else{
                                        System.out.println(pointPlayerTwo++);}
                                }
                                else{
                                    System.out.println("Miss!");
                                    rowPlayer4 = rowPlayer4.substring(0,columnNumGuess) + 'O' + rowPlayer4.substring(columnNumGuess + 1);
                                }
                                break;
                        }
                        }
                        }
                else{
                    System.out.println("Invalid guess. Try again.");
                    }
    
        }while(totalHit < 5);


        //end
        for(int count=0; count < rowPlayer0.length(); count++){
            System.out.print(rowPlayer0.charAt(count)+" ");
        }
        System.out.println();
        for(int count=0; count < rowPlayer1.length(); count++){
            System.out.print(rowPlayer1.charAt(count)+" ");
        }
        System.out.println();
        for(int count=0; count < rowPlayer2.length(); count++){
            System.out.print(rowPlayer2.charAt(count)+" ");
        }
        System.out.println();
        for(int count=0; count < rowPlayer3.length(); count++){
            System.out.print(rowPlayer3.charAt(count)+" ");
        }
        System.out.println();
        for(int count=0; count < rowPlayer4.length(); count++){
            System.out.print(rowPlayer4.charAt(count)+" ");
        }
        System.out.println();
        System.out.println("*********************");
        System.out.println("Game finished!");
        System.out.println("Total rounds played: "+(int)rounds);
        System.out.println("Total guesses: "+totalGuesses);
        System.out.printf("Player1 score: %d ships found%n",pointPlayerZero);
        System.out.printf("Player2 score: %d ships found%n",pointPlayerOne);
        System.out.printf("Player3 score: %d ships found%n",pointPlayerTwo);
        String winner = "";
        boolean tie = false;
        if(pointPlayerZero > pointPlayerOne && pointPlayerZero > pointPlayerTwo){
            winner = "Player1";
        }
        else if(pointPlayerOne > pointPlayerZero && pointPlayerOne > pointPlayerTwo){
            winner = "Player2";
        }
        else if(pointPlayerTwo > pointPlayerOne && pointPlayerTwo > pointPlayerZero){
            winner = "Player3";
        }
        else if(pointPlayerZero == pointPlayerOne || pointPlayerZero == pointPlayerTwo || pointPlayerOne == pointPlayerTwo){
            tie = true;
        }
        if(tie){System.out.println("It's a tie!");}
        else{System.out.printf("Winner: %s%n",winner);}
    }
}