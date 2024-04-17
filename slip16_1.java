import java.util.*;
public class slip16_1 {
    public static void main(String[] args) {
        TreeSet<String> colors = new TreeSet<>();
        System.out.println("Enter colors");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter Color names");
        String []colorsName = new String[n];
        for (int i = 0; i < n; i++){
            String names = colorsName[i] = sc.nextLine();
            colors.add(names);
        }

        System.out.println("Colors");
        for(String c : colors){
            System.out.println(c);
        }
    }
}
