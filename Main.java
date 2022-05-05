import java.util.*;
import demo.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        shows show = new shows();
        show.showsPresent();
        // System.out.println(totalShows);
        boolean accountflag=false;
        boolean flag=true;
        while (flag) {

            System.out.println("Choose one :");

            System.out.println("1- Create Account");
            System.out.println("2- View Show and Get Details");
            System.out.println("3- Book Ticket");
            System.out.println("4- Exit");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.print("Enter Name: "); // name
                    String name = sc.next();

                    System.out.print("Enter Age: "); // age
                    int age = sc.nextInt();

                    System.out.print("Enter Phone Number: "); // number
                    String phone = sc.next();

                    System.out.print("Enter yout Email: "); // email
                    String email = sc.next();
                    currentPerson p1 = new currentPerson(name, age, phone, email);
                    accountflag= p1.checkIfCreated();
                    System.out.println();
                    break;

                case 2:
                    if(!accountflag){
                        System.out.println("Create account first!!!!");
                        System.out.println();
                        break;
                    }
                    show.getDetails();
                    System.out.print("Enter movie name: ");
                    break;

                case 3:
                    if(!accountflag){
                        System.out.println("Create account first!!!!");
                        System.out.println();
                        break;
                    }
                    System.out.print("Enter Movie name: ");
                    String movie = sc.next();
                    System.out.println("Enter the number of tickets: ");
                    int noOfTickets = sc.nextInt();
                    show.checkAndBook(movie, noOfTickets);
                    break;

                case 4:
                    flag=false;
                    break;

            }
            System.out.println();
        }

    }
}

class currentPerson {
    boolean account;
    currentPerson(String name, int age, String phone, String email) {
        if (age < 18) {
            System.out.println("sorry Your account can't be created");
            this.account=false;
            return;
        }
        boolean phoneflag=true;
        for(int i=0;i<phone.length();i++){
            if(!Character.isDigit(phone.charAt(i)))
                phoneflag=false;
        }
        if(phone.length()!=10 && !phoneflag){
            System.out.println("Enter valid phone number");
            this.account=false;
            return;
        }
        Person p1 = new Person();
        p1.getPerson(name, age, phone, email);
        System.out.println("Account created Successfully!!");
        this.account=true;
    }
    boolean checkIfCreated(){
        return account;
    }
}

class shows {
    String movies[] = { "RRR", "KGF", "Fantastic Beast" };
    String theater[] = { "inox", "inox", "sangam" };
    int availability[] = { 45, 12, 100 };
    Shows us;

    void showsPresent() {
        us = new Shows();
        us.updateShows(movies, theater, availability);
        
    }
    void getDetails(){
        us.showMovie();
    }

    void checkMovie(String film) {
        us.showDetails(film);
    }

    void checkAndBook(String movie, int noOfTickets) {
        if (us.bookIfAvailable(movie, noOfTickets))
            System.out.println("Tickets booked!!");
        else
            System.out.println("tickets soldout");
    }
}