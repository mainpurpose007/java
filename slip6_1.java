import java.util.*;

public class slip6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of n");
        int n = sc.nextInt();
        TreeSet <Integer> values = new TreeSet<>();

        System.out.println("Enter the values");
        for(int i = 0; i < n; i++){
            int input = sc.nextInt();
            values.add(input);
        }
        System.out.println("Sorted Data is");
        for(int store : values){
            System.out.print(store + " ");
        }

        System.out.println("Enter value for search");
        int searchValue = sc.nextInt();
        if(values.contains(searchValue)){
            System.out.println("your value is available");
        }else{
            System.out.println("Your value is not valid and available");
        }

    }
}
