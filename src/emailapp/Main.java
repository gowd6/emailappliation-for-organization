package emailapp;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter first name:");

        String f_name=sc.next();
        System.out.println("Enter last name:");
        String l_name=sc.next();
        Email em1=new Email(f_name,l_name);
        int choice=-1;
        do{
            System.out.println("\n******\nEnter your choice\n1.Show Info\n2.Change password\n3.Change mailbox capacity \n4.Set Alternate mail\n5.Store data in file\n6.Read file\n7.exit");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailcap();
                    break;
                case 4:
                    em1.alternate_mail();
                    break;
                case 5:
                    em1.Storagefile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using application!");
                    break;
                default:
                    System.out.println("Invalid choice \nEnter proper choice again");

            }
        }while(choice!=7);
        }

}