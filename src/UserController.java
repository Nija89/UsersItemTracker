import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserController{

    private Scanner myScanenr = new Scanner(System.in);
    private List<User> myUserArrayList = new ArrayList<>();
    private List<String> universalItem = new ArrayList<>();
    private static User curretnLoggedInUser = null;
    private static boolean loggedIn = false;


    public void UserAddItem() {
        if (curretnLoggedInUser == null ) {
            System.out.println("Please Login First");
        } else {
            Item goingToBeAddedItem = curretnLoggedInUser.addItem();
            universalItem.add(goingToBeAddedItem.getName() + " was added by " + curretnLoggedInUser.getName());
        }
    }
    public void showUserItem() {
        if (curretnLoggedInUser == null) {
            System.out.println("Please Login First.");
        } else {
            curretnLoggedInUser.showItem();
        }
    }
    public void showUniversalItem(){
        System.out.println("Total Item : " + universalItem.size());
        for(int i=0; i< universalItem.size(); i++){
            System.out.println((i+1) +". " + universalItem.get(i));
        }
    }




















    public void Login() {
        if (myUserArrayList.isEmpty()) {
            System.out.println("Please Add a User.");
        } else {
            if (!loggedIn) {
                System.out.print("Enter your name: ");
                String name = myScanenr.nextLine();
                System.out.print("Enter your password: ");
                String password = myScanenr.nextLine();

                for (int i = 0; i < myUserArrayList.size(); i++) {
                    User currentUser = myUserArrayList.get(i);
                    if (currentUser.getName().equals(name) && currentUser.getPassword().equals(password)) {
                        loggedIn = true;
                        curretnLoggedInUser = currentUser;
                        System.out.println("You successfully logged in. ");
                    } else {
                        System.out.println("Invalid Name or Password. ");
                    }
                }
            } else {
                System.out.println("You are already LoggedIn. " + curretnLoggedInUser.getName());
            }
        }
    }

    public void Logout(){
        if(loggedIn){
            loggedIn = false;
            curretnLoggedInUser = null;
            System.out.println("Successfully Logged Out.");
        }else{
            System.out.println("You are already Logged out. Please Login.");
        }
    }

    public void addUser(){
        if(!loggedIn) {
            System.out.print("Enter your name: ");
            String name = myScanenr.nextLine();
            System.out.print("Enter your password: ");
            String password =  myScanenr.nextLine();

            boolean doseExist = false;
            for (int i = 0; i < myUserArrayList.size(); i++) {
                User currentUser = myUserArrayList.get(i);
                if (currentUser.getName().equals(name)) {
                    doseExist = true;
                    System.out.println("User already Exist.");
                    break;
                }
            }
            if (!doseExist) {
                myUserArrayList.add(new User(name, password));
                System.out.println(name + " successfully added.");
            }
        }else{
            System.out.println("Please Logout First.");
        }
    }

    public void showUser(){
        System.out.println("Total Number of User : " + myUserArrayList.size());
        for( int i=0  ; i< myUserArrayList.size(); i++){
            User currentUser = myUserArrayList.get(i);

            System.out.println((i+1) + ". " + currentUser.getName());
        }
    }

}