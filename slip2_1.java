import java.util.*;

public class slip2_1 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students");
        int n = sc.nextInt();
        sc.nextLine();


        Set<String> friends = new HashSet<>();
        for (int i = 0; i < n; i++){
            System.out.println("Enter Friends names " + i + 1);
            String f = sc.next();
            friends.add(f);
        }

        System.out.println("Ascending Order");
        Set<String> friendList = new TreeSet<>(friends);

        for (String sortedFriendList : friendList){
            System.out.println(sortedFriendList);
        }
        sc.close();
    }
}
