package PatientRecSys;

import java.util.Scanner;

import patient.crud.CRUD;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CRUD cr=new CRUD();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to Add Patient :");
        System.out.println("Enter 2 to Get All Patient Record :");
        System.out.println("Enter 3 to Update Patient :");
        System.out.println("Enter 4 to Delete Patient :");
        int i=sc.nextInt();
        
        switch (i) {
		case 1:{
			cr.add();
			break;
		}
		case 2:{
			cr.getAll();
		}
		case 3:{
			cr.update();
			break;
		}
		case 4:{
			cr.delete();
			break;
		}

		}
    }
}
