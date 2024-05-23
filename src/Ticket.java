import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String printTicketInformation() {
        String dets = "Row: " + getRow() + "\n" + "Seat: " + getSeat() + "\n" + "Price: " + getPrice() + "\n";
        System.out.println(dets);
        String pdets = person.printPersonInformation();
        return (dets + pdets);
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter(getRow() + getSeat() + ".txt");
            writer.write(printTicketInformation());
            writer.close();
            System.out.println("Data Saved To File");
        } catch (IIOException e) {
            System.out.println("An Error has occurred while saving the data to file. ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete() { //this method is created for a scenario of when a person buys a ticket cancels it and then no one else buys it again
        String fileName = getRow() + getSeat() + ".txt";
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File Deleted");
            } else {
                System.out.println("Failed to Delete File");
            }
        } else {
            System.out.println("File Does Not Exist");
        }
    }
}