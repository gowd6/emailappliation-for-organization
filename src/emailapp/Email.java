package emailapp;
import java.util.*;
import java.io.*;
public class Email {
    public Scanner sc=new Scanner(System.in);
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity=500;
    private String alter_mail;
    public Email(String fname,String lname){
        this.fname=fname;
        this.lname=lname;
        System.out.println("New Employee:"+this.fname+" "+this.lname);
        this.dept=this.setDept();
        this.password=this.genarate_password(8);
        this.email=this.generate_email();
    }
    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }
    private String setDept(){
        System.out.println("Department codes \n1 for sales \n2 for Development \n3 for Accounting ");
        boolean flag=false;
        do {
            System.out.println("Enter Department code");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");

            }
        }while(!flag);
            return null;



    }
    private String genarate_password(int length){
        Random r=new Random();
        String capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_chars="abcdefghijklmnopqrstuvwxyz";
        String Numbers="0123456789";
        String symbols="@#$%&?";
        String values=capital_chars+small_chars+Numbers+symbols;
        String password="";
        for(int i=0;i<length;i++){
            password=password+values.charAt(r.nextInt(values.length()));

        }
        return password;
    }
    public void set_password(){
        boolean flag=false;
        do{
            System.out.println("Do you want to change your password!(Y/N)");
            char choice=sc.next().charAt(0);
            if(choice=='Y'|| choice=='y') {
                flag = true;
                System.out.println("Enter current password:");
                String temp=sc.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new password:");
                    this.password=sc.next();
                    System.out.println("Password changed successfully");
                }
                else{
                    System.out.println("Incorrect password");
                }


            }
            else if(choice=='N'||choice=='n'){
                flag=true;
                System.out.println("Password changed option cancelled!");

            }
            else{
                System.out.println("Enter valid choice");
            }


        }while(!flag);
    }
    public void set_mailcap(){
        System.out.println("Current capacity="+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity= sc.nextInt();
        System.out.println("Mail capacity is successfully changed");
    }
    public void alternate_mail(){
        System.out.println("Enter new alternate mail: ");
        this.alter_mail=sc.next();
        System.out.println("Alternate email is set");
    }
    public void getInfo(){
        System.out.println("Name:"+this.fname+this.lname);
        System.out.println("Department:"+this.dept);
        System.out.println("Email:"+this.email);
        System.out.println("Password:"+this.password);
        System.out.println("Mailbox capacity:"+this.mailCapacity+"mb");
        System.out.println("Alternate mail:"+this.alter_mail);
    }
    public void Storagefile(){
        try{
            FileWriter in=new FileWriter("C:\\Users\\bhuth\\OneDrive\\Desktop\\vsb.txt");
             in.write("First name:"+this.fname);
             in.append("\nLast name:"+this.lname);
             in.append("\nEmail:"+this.email);
             in.append("\nPassword:"+this.password);
             in.append("\nCapacity:"+this.mailCapacity);
             in.append("\nAlternate mail:"+this.alter_mail);
             in.close();
             System.out.println("Data Stored..");
        }
        catch(Exception e){
            System.out.println(e);

        }
    }
    public void read_file() {
        try {
            FileReader f1 = new FileReader("C:\\\\Users\\\\bhuth\\\\OneDrive\\\\Desktop\\\\vsb.txt");
            int i;
            while((i=f1.read())!=-1){
                System.out.print((char)i);
            }
            System.out.println();
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
