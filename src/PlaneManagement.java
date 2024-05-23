import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class PlaneManagement {

    static int[] rowA = new int[14];
    static int[] rowB = new int[12];
    static int[] rowC = new int[12];
    static int[] rowD = new int[14];
    private static Ticket []Tickets = new Ticket[52];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Plane Management Application\n");

        //task2 Displaying Menu Options
        while (true) {
            try {

                System.out.println("****************************************************\n");
                System.out.println("*                  MENU OPTIONS                    *\n");
                System.out.println("****************************************************\n");

                System.out.println("     1) Buy a seat");
                System.out.println("     2) Cancel a Seat");
                System.out.println("     3) Find first available seat");
                System.out.println("     4) Show seating plan");
                System.out.println("     5) Print tickets information and total sales");
                System.out.println("     6) Search Ticket");
                System.out.println("     0) Quit\n");

                System.out.println("****************************************************\n");
                System.out.print("Please select an option: ");

                int option = Integer.parseInt(input.nextLine());

                switch (option) {
                    case 1:
                        buy_seat();
                        break;

                    case 2:
                        cancel_seat();
                        break;

                    case 3:
                        find_first_available();
                        break;

                    case 4:
                        show_seating_plan();
                        break;

                    case 5:
                        print_tickets_info();
                        break;

                    case 6:
                        search_ticket();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Please Enter Valid Number...!");
                        break;
                }
            }catch(NumberFormatException | InputMismatchException e){
                System.out.println("Invalid Option Number....!");
            }
        }
    }

    public static String rowLetter(){

        Scanner input = new Scanner(System.in);
        String [] arrLetters = {"A", "B", "C", "D"};

        String rowLetter=null;
        //validating the input row letter is correct
        try {
            boolean condition = true;
            while(condition){
                System.out.print("Enter Row Letter: ");
                rowLetter = input.nextLine().toUpperCase();
                boolean validity = false;
                for (int x = 0; x < arrLetters.length; x++) {
                    if (arrLetters[x].equals(rowLetter)) {
                        validity = true;
                        break;
                    }
                }
                if(!validity){
                    System.out.println("Enter Valid Row Letter...!");
                }else{
                    condition=false;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please Enter Valid Row Letter...!\n");
        }
        return rowLetter;
    } //code block is used to Validate Row Letters within range

    public static int seatNumber(String rowLetter){
        //validating the input row number is within range
        Scanner input = new Scanner(System.in);

        int seatNumber;
        while (true) {
            try {
                System.out.print("Enter Seat Number: ");
                seatNumber = Integer.parseInt(input.nextLine());
                if (rowLetter.equals("A") || rowLetter.equals("D")) {
                    if (seatNumber > 0 && seatNumber < 15) {
                        break;
                    } else {
                        System.out.println("Input Seat Number out of Range. Enter Value between 1 and 14\n");
                    }
                } else {
                    if (seatNumber > 0 && seatNumber < 13) {
                        break;
                    } else {
                        System.out.println("Input Seat Number out of Range. Enter Value between 1 and 12\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a Valid Number...!\n");
                //continue;
            }catch(Exception e){
                System.out.println("Continuing");
            }
        }
        return seatNumber;

    } //Code block is used to validate Seat Number within range

    public static double price (int seatNumber){
        double price;
        if (seatNumber <= 5){
            price = 200;
        } else if (seatNumber <= 9) {
            price = 150;
        }else {
            price = 180;
        }
        return price;
    } //Retrieving price according to the input Row Letter and Seat Number
    public static String nameChecker (){
        Scanner input = new Scanner(System.in);
        String name;
        name = input.nextLine();
        try{
            if (name.matches("[a-zA-Z]+")){
                /*a-zA-Z will check the alphabetical range in both Upper and Lower Cases
                while "+" is used to check it throughout String length */
                return name;
            }else {
                System.out.println("Input Valid String Value...!\n");
                name = null;
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }return name;
    } //validating whether the input name is a complete String Value as a name cannot have numbers

    public static void buy_seat() {

        String rowLetter = rowLetter();
        int seatNumber = seatNumber(rowLetter);

        switch (rowLetter) {

            case "A":

                if (rowA[seatNumber - 1] == 0) {
                    System.out.println("Seat is Available.\n");
                    rowA[seatNumber - 1] = 1;
                } else {
                    System.out.println("Seat is NOT Available...!\n");
                    return;
                }
                break;

            case "B":
                if (rowB[seatNumber - 1] == 0) {
                    System.out.println("Seat is Available.\n");
                    rowB[seatNumber - 1] = 1;
                } else {
                    System.out.println("Seat is NOT Available...!\n");
                    return;
                }
                break;

            case "C":
                if (rowC[seatNumber - 1] == 0) {
                    System.out.println("Seat is Available.\n");
                    rowC[seatNumber - 1] = 1;
                } else {
                    System.out.println("Seat is NOT Available...!\n");
                }
                break;

            case "D":
                if (rowD[seatNumber - 1] == 0) {
                    System.out.println("Seat is Available.\n");
                    rowD[seatNumber - 1] = 1;
                } else {
                    System.out.println("Seat is NOT Available...!\n");
                }
                break;
        }
        Scanner input = new Scanner(System.in);

        String name;
        //The following code block is to Validate the Name. Mostly done in nameChecker method.
        do {
            System.out.println("Enter Name");
            name = nameChecker();
        } while (name == null);

        String surname;
        //following code block is to validate the Surname. Mostly done in nameChecker method.
        do {
            System.out.println("Enter Surname");
            surname = nameChecker();
        } while (surname == null);

        System.out.print("Enter Email: ");
        String email = input.nextLine();

        System.out.println("Seat is Sold!");

        Person person = new Person(name, surname, email); //Creating an Object for Person


        double price = price(seatNumber);

        Ticket ticket = new Ticket(rowLetter, seatNumber, price, person); //Creating an Object for Ticket

        for (int i = 0; i < Tickets.length; i++) {
            if (Tickets[i]==null) {
                Tickets[i] = ticket;
                break;
            }
        }
        ticket.save();

    }

    public static void cancel_seat() {

        String rowLetter = rowLetter();
        int seatNumber = seatNumber(rowLetter);

        switch (rowLetter) {

            case "A":

                if (rowA[seatNumber - 1] == 0) {
                    System.out.println("Seat is Already Available. Cannot be Cancelled\n");
                } else {
                    System.out.println("Seat has been Cancelled.\n");
                    rowA[seatNumber - 1] = 0;
                }
                break;

            case "B":
                if (rowB[seatNumber - 1] == 0) {
                    System.out.println("Seat is Already Available. Cannot be Cancelled\n");
                } else {
                    System.out.println("Seat has been Cancelled.\n");
                    rowB[seatNumber - 1] = 0;
                }
                break;

            case "C":
                if (rowC[seatNumber - 1] == 0) {
                    System.out.println("Seat is Already Available. Cannot be Cancelled\n");
                } else {
                    System.out.println("Seat has been Cancelled.\n");
                    rowC[seatNumber - 1] = 0;
                }
                break;

            case "D":
                if (rowD[seatNumber - 1] == 0) {
                    System.out.println("Seat is Already Available. Cannot be Cancelled\n");
                } else {
                    System.out.println("Seat has been Cancelled.\n");
                    rowD[seatNumber - 1] = 0;
                }
                break;
        }
        for (int i = 0; i < Tickets.length; i++) {
            if (Tickets[i]!=null){
                String ticketRowLetter = Tickets[i].getRow();
                int ticketSeatNumber = Tickets[i].getSeat();
                if (Objects.equals(ticketRowLetter, rowLetter) && ticketSeatNumber == seatNumber) {
                    Tickets[i] = null;
                }
            }
        }
        Ticket ticket = new Ticket(rowLetter, seatNumber, 0, null);
        ticket.delete();

    }

    public static void find_first_available(){

        int [][] seatingPlan = {rowA, rowB, rowC, rowD};
        String[] rowLetter = {"A", "B", "C", "D"};

        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                if(seatingPlan[i][j] == 0){
                    System.out.println("First seat available in Row " + rowLetter[i] + ": " + (j + 1));
                    break;
                }
            }
        }
    }

    public static void show_seating_plan(){

        int [][] seatingPlan = {rowA, rowB, rowC, rowD};
        String[] rowLetter = {"A", "B", "C", "D"};

        for (int i = 0; i < seatingPlan.length; i++) {
            System.out.print("Row " + rowLetter[i] + ": ");
            for (int j = 0; j < seatingPlan[i].length; j++) {
                System.out.print(seatingPlan[i][j] == 0 ? "0":"X");
            }
            System.out.println();
        }

    }

    public static void print_tickets_info(){
        double totalPrice = 0;
        for (int a = 0; a < Tickets.length; a++) {
            if (Tickets[a]!=null) {
                Tickets[a].printTicketInformation();
                totalPrice += Tickets[a].getPrice();
                System.out.println();
            }else {
                continue;
            }
            System.out.println("Total Price is: £"+totalPrice);
        }
    }

    public static void search_ticket (){

        String rowLetter = rowLetter();
        int seatNumber = seatNumber(rowLetter);

        for (int i = 0; i < Tickets.length; i++) {
            if (Tickets[i]!=null) {
                String rowLetterMatch = Tickets[i].getRow();
                int seatNumberMatch = Tickets[i].getSeat();
                if (Objects.equals(rowLetter, rowLetterMatch) && seatNumber==seatNumberMatch){
                    Tickets[i].printTicketInformation();
                    return;
                }
            }
        }
        System.out.println("This seat is available");


    }

}