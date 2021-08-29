import java.util.Arrays;   
import java.util.Random;

public class MitProgram{
    public static int minNumber = 1;
    public static int maxNumber = 200;  

    public static int[] array = new int[maxNumber];
    
    public static int selectedNumber;
    public static boolean foundNumber;

    public static void main(String[] args){
        for(int i = 1; i<array.length; i++){
            Random numbers = new Random();
            array[i] = numbers.nextInt(maxNumber-minNumber);
        }

        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(array) + "\n");

        sortArray();
        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(array) + "\n");

        Random rand = new Random();
        selectedNumber = rand.nextInt(maxNumber-minNumber);
        
        System.out.println("The selected number is " + array[selectedNumber]);
        
        while(!foundNumber){
            int arraySpot = ((maxNumber-minNumber)/2)+minNumber;
            System.out.println("Searching for number: " + array[arraySpot] + ", in array spot: " + (arraySpot+1));
            searchNumber(arraySpot);
        }
    }

    static void sortArray(){
        for(int i = 1; i<array.length; i++){
            if(array[i] < array[i-1]){
                boolean done = false;
                int checking = 1;

                while(!done){
                    if(array[i] >= array[i-checking]){
                        int tempNumber = array[i];
                        int[] tempArray = new int[checking-1];

                        for(int b = 0; b<tempArray.length;b++){
                            tempArray[b] = array[i-checking+1+b];
                        }
            
                        for(int b = 0; b<tempArray.length; b++){
                            array[i-checking+1+b+1] = tempArray[b];
                        }
                        array[i-checking+1] = tempNumber; 
                        done = true;
                    }
                    checking++;
                }
            }
        }
    }

    static void searchNumber(int number){
        if(number>selectedNumber){
            maxNumber = number-1;
            System.out.println("The number is below " + array[number]+ "\n");
        }   
        if(number<selectedNumber){
            minNumber = number+1;
            System.out.println("The number is above " + array[number]+ "\n");
        }
        if(number==selectedNumber){
            foundNumber = true;
            System.out.println("The number " + array[number] + " has been found, in array spot " + (number+1) + "\n");
        }
    }
}