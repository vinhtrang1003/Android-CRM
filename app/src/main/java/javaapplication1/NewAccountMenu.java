/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC200
 */
public class NewAccountMenu implements AccountMenuInterface {
    public void execute(List<Account> accounts){
        Scanner scannerOject = new Scanner(System.in);
        System.out.println("Enter Account Name: ");
        String accName = scannerOject.nextLine();
        System.out.println("Enter Industry: ");
        String industry = scannerOject.nextLine();
        System.out.println("Enter Billing City: ");
        String billCity = scannerOject.nextLine();
        System.out.println("Enter Billing State: ");
        String billState = scannerOject.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNum = scannerOject.nextLine();
        System.out.println("Enter Owner Name: ");
        String ownerName = scannerOject.nextLine();
        accounts.add(new Account( accName,industry,billCity,billState,phoneNum,ownerName));
    }
    public String toString() 
    { 
        return "Make a new Account";
    } 

}
