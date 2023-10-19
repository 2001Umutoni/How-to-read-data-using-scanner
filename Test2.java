/*
 * 
 */

/**How to read data using scanner
 *
 * @author HP
 */

    
package introduction;

import java.util.*;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Ange
 */
public class Test2 {
    public static void main(String[] args) {
        
    
        boolean condition = true;
        //String dbUrl ="jdbc:mysql://localhost:3306/thursdayevening","root","atessy02";
      
        int patient_id;
        String patient_names;
        while(condition){
            System.out.println("=================");
            System.out.println("1. Create a Patient Manual");
            System.out.println("2. Create a Patient Dynamically");
            System.out.println("3. Update a Patient Manual");
            System.out.println("4. Update a Patient Dynamically");
            System.out.println("5. Delete a Patient manual");
            System.out.println("6. Delete a Patient Dynamically");
            System.out.println("7. Retrieve all Patient");
            System.out.println("8. Search Patient by Id ");
            System.out.println("0. Exit");
            System.out.println("Choice==> ");
             // System.out.println("\n");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
               case 1:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
                        Statement st = con.createStatement();
                        String sql = "insert into patient (patient_id, patient_names) values(1,'Anny Ineza')";
                        int rowAffected = st.executeUpdate(sql);
                        if (rowAffected >= 1) {
                            System.out.println("Patient Created");
                        } else {
                            System.out.println("Patient not created");
                        }
                        con.close();
                        System.out.println("Enter Yes or No to continue or to exit: ");
                        String answer = sc.next();
                        if (answer.equalsIgnoreCase("yes")) {
                            condition = true;
                        } else {
                            System.out.println("Thank you for using the system");
                            condition = false;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;

               case 2:
    try {
        System.out.print("Enter patient ID: ");
        patient_id = sc.nextInt();
        System.out.println("Enter patient Name: ");
        patient_names = sc.next();
          System.out.println("\n\n");

        if (patient_names.length() < 3) {
            System.out.println("Patient's name must be of 3 characters or more.");
            System.out.println("\n\n");
        } else {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
            Statement st = con.createStatement();
            String sql = "insert into  patient (patient_id, patient_names) values ('" + patient_id + "','" + patient_names + "')";
            int rowAffected = st.executeUpdate(sql);
            if (rowAffected >= 1) {
                System.out.println("Patient Saved!");
            } else {
                System.out.println("Patient Not Saved!");
            }

            con.close();
            System.out.print("Enter Yes or No to continue: ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("yes")) {
                condition = true;
            } else {
                System.out.println("Thank you for using the system");
                condition = false;
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    break;
                case 3: 
                    try{
                        // create a connection
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
                        // create statement
                        Statement st = con.createStatement();
                        // execute statement
                        String sql = "update patient set patient_names='imena' where patient_id='8'";
                        int rowAffected = st.executeUpdate(sql);
                        if(rowAffected>=1){
                            System.out.println("patient Updated!");
                        }else{
                            System.out.println("patient not Updated!");
                        }
                        // close connection
                        con.close();
                        System.out.print("Enter Yes or No to continue: ");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition =true;
                        }else{
                            System.out.println("Thank you for using system");
                            condition =  false;
                        }
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    
                    //System.out.println("Second Option");
                    break;
                      case 4:
                    System.out.println("Update Dynamically");
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
       
        System.out.println("Enter the patient ID you want to update: ");
        int patientIdToUpdate = sc.nextInt();
        sc.nextLine(); // go to next line
        System.out.println("Enter the new patient name: ");
        String newPatientName = sc.nextLine();

        String sql = "UPDATE patient SET patient_names = ? WHERE patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, newPatientName);
       ps.setInt(2, patientIdToUpdate);

        int rowAffected = ps.executeUpdate();

        if (rowAffected >= 1) {
            System.out.println("Patient Updated");
        } else {
            System.out.println("Patient not updated");
        }

        con.close();

        System.out.println("Enter 'Yes' or 'No' to continue or exit: ");
        String answer = sc.next();

        if (answer.equalsIgnoreCase("Yes")) {
            condition = true;
        } else {
            System.out.println("Thank you for using the system");
            condition = false;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    break;
                    
                    case 5:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
                        Statement st = con.createStatement();
                        String sql = "delete from patient where patient_id='3'";
                        int rowAffected = st.executeUpdate(sql);
                        if(rowAffected >=1){
                            System.out.println("Data Deleted");
                        }else{
                            System.out.println("Data Not Deleted");
                        }
                        con.close();
                        System.out.print("Enter Yes or No to continue: ");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition =true;
                        }else{
                            System.out.println("Thank you for using system");
                            condition =  false;
                        }
                        con.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                    case 6:
                   //System.out.println("Delete Dynamically");
    try {
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
       
        System.out.println("Enter the patient ID you want to delete: ");
        int patientIdToDelete = sc.nextInt();

        String sql = "DELETE FROM patient WHERE patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, patientIdToDelete);

        int rowAffected = ps.executeUpdate();

        if (rowAffected >= 1) {
            System.out.println("Patient Deleted");
        } else {
            System.out.println("Patient not deleted");
        }

        con.close();

        System.out.println("Enter 'Yes' or 'No' to continue or exit: ");
        String answer = sc.next();

        if (answer.equalsIgnoreCase("Yes")) {
            condition = true;
        } else {
            System.out.println("Thank you for using the system");
            condition = false;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
   
                      break;
                      case 7:
                                try{
                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
                        Statement st = con.createStatement();
                        String sql = "select * from patient";
                        ResultSet result = st.executeQuery(sql);// execute querry only used for retrieving data in db and use Result will hold all information fron\m db
                        int counter = 0;
                        boolean flag = false;
//                        if(result.next() == false){
//                            System.out.println("No Data Recorded Yet");
//                        }
                        while(result.next()){
                            flag = true;
                            counter++;
//                            counter +=1;
//                            counter  = counter +1;
                            System.out.println("patient "+counter);
                            System.out.println("----------");
                            System.out.println("patient ID  : "+result.getInt("patient_id"));
                            System.out.println("Patient Name: "+result.getString("patient_names"));
                           
                            
                        }
                        if(flag == false){
                            System.out.println("No Data Recorded Yet");
                        }
                        con.close();
                        System.out.print("Enter Yes or No to continue: ");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition =true;
                        }else{
                            System.out.println("Thank you for using system");
                            condition =  false;
                        }
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    System.out.println("Retrieve data");
                    break;
                  
                  case 8:
    System.out.println("Search by Patient ID");
    try {
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thursdayevening","root","atessy02");
       
        System.out.println("Enter the patient ID you want to search for: ");
        int searchId = sc.nextInt();

        String sql = "SELECT * FROM patient WHERE patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, searchId);

        ResultSet result = ps.executeQuery();

        if (result.next()) {
            System.out.println("Patient found:");
            System.out.println("Patient ID: " + result.getInt("patient_id"));
            System.out.println("Patient Name: " + result.getString("patient_names"));
        } else {
            System.out.println("Patient not found");
        }

        con.close();

        System.out.println("Enter 'Yes' or 'No' to continue or exit: ");
        String answer = sc.next();

        if (answer.equalsIgnoreCase("Yes")) {
            condition = true;
        } else {
            System.out.println("Thank you for using the system");
            condition = false;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    break;
                    /*
                    try{
                     Connection con = DriverManager.getConnection(dbUrl, username, password);
       
        System.out.println("Enter the patient ID you want to update: ");
        int searchid = sc.nextInt();
        sc.nextLine(); 
                    string sql = "SELECT * from patient where patient_id=("'+searchid);
                    
                    }
                    */
                    
                  
                case 0:
                    System.out.println("Thank you for using the system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Else part");
                   
            }
        }
    }
}


