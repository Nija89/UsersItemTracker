import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private Scanner myScanner = new Scanner(System.in);
    private final String name;
    private final String password;
    private List<Item> myPersonalItem = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    public Item addItem(){
        System.out.print("Enter a item name: ");
        String name =  myScanner.nextLine();

        myPersonalItem.add(new Item(name));
        return new Item(name);
    }

    public void showItem(){
        for(int i=0; i< myPersonalItem.size(); i++){
            System.out.println((i+1) + ". " + myPersonalItem.get(i).getName() + " -> " + " added by " + this.name);
        }
    }

}
