import java.util.*;

public class slip4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String , Integer> STDCode = new HashMap<>();
        STDCode.put("India" , 91);
        STDCode.put("USA" , 1);
        STDCode.put("Korea" , 82);
        STDCode.put("Japan" , 81);

        int choice;
        do{
            System.out.println("Select Following choice");
            System.out.println("1: Add a new city and its code");
            System.out.println("2: Remove a city from the collection");
            System.out.println("3: Search for a city name and display the code");
            System.out.println("4: Show available city names");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter city name");
                    String cityName = sc.next();
                    System.out.println("Enter City code ");
                    int cityCode = sc.nextInt();
                    if(!STDCode.containsKey(cityName)){
                        STDCode.put(cityName , cityCode);
                    }else{
                        System.out.println("City Name already exist.");
                    }
                    break;

                case 2:
                    System.out.println("Enter city name for the remove");
                    String removeCityName = sc.next();
                    if(STDCode.containsKey(removeCityName)){
                        STDCode.remove(removeCityName);
                        System.out.println("Your city was removed");
                    }else{
                        System.out.println("City not found");
                    }
                    break;

                case 3:
                    System.out.println("Enter city Name for searching its code");
                    String cityNameSearch = sc.next();
                    if(STDCode.containsKey(cityNameSearch)){
                        System.out.println("City Name : " + cityNameSearch + " and Code : " + STDCode.get(cityNameSearch));
                    }

                case 4:
                    System.out.println("Available cities are following");
                    for (String available:
                         STDCode.keySet()) {
                        System.out.println(available);
                    }
            }
        }while(choice != 5);
        sc.close();
    }
}
