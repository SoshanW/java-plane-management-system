import java.util.Scanner;

public class Person {

    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setEmail(String email){
        this.email =email;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getEmail(){
        return this.email;
    }

    public String printPersonInformation(){
        String pdets = "Name: "+getName()+"\n"+"Surname: "+getSurname()+"\n"+ "Email: "+getEmail();
        System.out.println(pdets);
        return pdets; //return function was created to make it easy in file creation
    }

}