import java.util.*;
public class slip17_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the inputs");
        int n = sc.nextInt();

        TreeSet<Integer> data = new TreeSet<>();

        System.out.println("Enter the Values in the set");
        for(int i = 0; i < n; i++){
            data.add(sc.nextInt());
        }
        System.out.println("Values are sorted (without duplicated)");
        for (Integer nos:
             data) {
            System.out.print(nos + " ");
        }

        sc.close();
    }
}
