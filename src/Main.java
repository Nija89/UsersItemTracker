import java.util.Scanner;

class Main{
    public static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {

        controller();

    }


    public static void controller(){
        UserController myUserController = new UserController();
        boolean isTrue = true;
        while(isTrue){
            showMap();
            System.out.print("Enter a number : ");
            boolean isInt = myScanner.hasNextInt();
            if(isInt){
                int action = myScanner.nextInt();
                myScanner.nextLine();
                switch(action){
                    case 0:
                        myUserController.showUser();
                        break;
                    case 1:

                        myUserController.addUser();
                        break;
                    case 2:
                        myUserController.Login();
                        break;
                    case 3:
                        myUserController.Logout();
                        break;
                    case 4:
                        myUserController.UserAddItem();
                        break;
                    case 5:
                        myUserController.showUserItem();
                        break;
                    case 6:
                        myUserController.showUniversalItem();
                        break;
                    case 10:
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Enter the number within the range !!!");
                }
            }else{
                System.out.println("Please Enter a Number Only!");
                myScanner.nextLine();
            }
        }
    }

    public static void showMap(){
        System.out.println("===========================");
        System.out.println(
                "0. View User \n" +
                        " 1. Add User\n" +
                        " 2. Login\n" +
                        " 3. Logout\n" +
                        " 4. Add Item\n" +
                        " 5. Show Item \n" +
                        " 6. Show all Item \n" +

                        " 10. Exit\n"
        );
        System.out.println();
    }
}