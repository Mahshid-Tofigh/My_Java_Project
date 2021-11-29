import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private String first_name;
    private String last_name;
    private String company_name;
    private String full_or_part;
    private String level_of_position;
    private String email;
    private String passWord;
    private int passWord_length = 8;
    int mail_box_capacity = 400;
    private String alternate_email;

    public Email(String first_name, String last_name,String company_name){
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_name = company_name;
        this.email = user_email();
        //System.out.println("Email created: "+ this.email);
        this.level_of_position = position_level();
        this.full_or_part = set_full_part();
        //System.out.println(first_name + " "+ last_name + " is a "+ this.full_or_part);
        System.out.println("The complete user information: ");
        System.out.println("Employee's name: "+first_name+" "+last_name);
        this.passWord = passwordGenerator(passWord_length);
        System.out.println("Generated password is: "+ this.passWord);

    }
    private String set_full_part() {
        System.out.println("Enter f for full time employee or p for part time employee: ");
        Scanner in = new Scanner(System.in);
        String empType = in.nextLine();
        switch(empType){
            case "f": empType = "full time employee"; break;
            case "p": empType = "Part time employee"; break;
        }
        return empType;
    }
    private String position_level(){
        System.out.println("Enter s for senior, a for associate, i for intermediate: ");
        Scanner in = new Scanner(System.in);
        String position = in.nextLine();
        switch (position){
            case "s" : position = "Senior"; break;
            case "i" : position = "Intermediate"; break;
            case "a" : position = "Associate"; break;
        }
        return position;

    }
    private String user_email(){
        String email =  first_name.toLowerCase()+"."+last_name.toLowerCase()+"@"+
                company_name + ".com";
        return email;
        }



    private String passwordGenerator(int length){
        String upper = "ABCDEFGHIJKLMNOPQRSTUV";
        String lower = "abcdefghijklmnopqrstuv";
        String number = "0123456789";
        String special_char = ",.?_-*&%$#@!";
        String combination = upper + lower + number + special_char;
        char[] password = new char[length];
        Random rand = new Random();
        for(int i=0; i<length; i++){
            int rand_index = rand.nextInt(combination.length());
            password[i] = combination.charAt(rand_index);
        }
        return  new String(password);
    }
    public void setMail_box_capacity(int capacity) {
        this.mail_box_capacity = capacity;
    }

    public void setAlternate_email(String alternate_email) {
        this.alternate_email = alternate_email;
    }
    public void changePassword(String password){
        this.passWord = password;
    }

    public String getAlternate_email() {
        return alternate_email;
    }

    public int getMail_box_capacity() {
        return mail_box_capacity;
    }

    public String getPassWord() {
        return passWord;
    }
    public String user_info(){
        return "Company name: "+ company_name + "\nUser email: " + email + "\nMailbox capacity: " + mail_box_capacity + "\nPosition level: "+ level_of_position+
                "\nFull time or Part time: "+ full_or_part;


    }


}

