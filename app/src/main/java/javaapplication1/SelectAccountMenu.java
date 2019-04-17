/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC200
 */
public class SelectAccountMenu implements AccountMenuInterface{
    private Account currentSelectedAcc;

    @Override
    public void execute(List<Account> acc) {
        int numOfAcc = acc.size();
        if (numOfAcc == 0){
            System.out.println("No Account is found");
            return;
        }
        Scanner scan = new Scanner(System.in);
        int num = 0;
        System.out.println("Select one of the Account below");
        for (Account i: acc){
            System.out.println(num+". " + i.getAccountName());
            num++;
        }
        int option = scan.nextInt();
        currentSelectedAcc = acc.get(option);
        
        int option2;
        option2 = 0;
        
        while (option2 != 6)
        {
        
        System.out.println("Select one of the Account options");
        System.out.println("0. Create new contact");
        System.out.println("1. List all contacts");
        // Vinh Add and list products
        System.out.println("2. Add a product");
        System.out.println("3. List all products");
        // Vinh Add and List All transaction
        System.out.println("4. Add a transaction");
        System.out.println("5. List all transaction");
        
        System.out.println("6. Go back to main menu");
        
        option2 = scan.nextInt();
        if (option2 == 1){
            currentSelectedAcc.listAllContacts();
        }
        else if (option2 == 0) {
            //String name, String title, int phone, String email
            
            Scanner scans = new Scanner(System.in);
            
            System.out.println("Enter Name: ");
            String name = scans.nextLine();
            System.out.println("Enter Title: ");
            String title = scans.nextLine();
            System.out.println("Enter Phone: ");
            String phone = scans.nextLine();
            System.out.println("Enter Email: ");
            String email = scans.nextLine();
            currentSelectedAcc.newContact(name , title, phone, email);
        }
        /////////////////// Vinh add and list products ///////////////////
        else if (option2 == 2) {
            //String name, String title, int phone, String email
            Scanner scanp = new Scanner(System.in);
            System.out.println("Enter Product Name: ");
            String Pname = scanp.nextLine();
            System.out.println("Enter Product ID: ");
            String PID = scanp.nextLine();
            System.out.println("Enter PPrice: ");
            Double PPrice = scanp.nextDouble();
            currentSelectedAcc.addProduct(Pname, PID, PPrice);
        }
        // List all products
        else if (option2 == 3) {
            currentSelectedAcc.listAllProducts();
        }
        /////////////////// Vinh add and list transaction ///////////////////
        else if (option2 == 4) 
        {
            System.out.println("Choose a customer from contact list: ");
            currentSelectedAcc.listAllContacts();
            Scanner scant = new Scanner(System.in);
            
            int c = scant.nextInt();
            Contact Customer = currentSelectedAcc.getContactLst().get(c);
            
            System.out.println("Choose a Product from Product list: ");
            currentSelectedAcc.listAllProducts();
            int p = scant.nextInt();
            Products Product = currentSelectedAcc.getProductsList().get(p);
            
            System.out.println("Quality to sell: ");
            int q = scant.nextInt();
            
            Scanner scanp = new Scanner(System.in);
            System.out.println("Record Transaction ID: ");
            String tid = scanp.nextLine();
            
            Transaction T = new Transaction("Null");
            T.CreateTransaction(Customer, Product, tid, q);
            
            currentSelectedAcc.addTrans(T);
            
        }
        else if (option2 == 5) 
        {
            currentSelectedAcc.listAllTransactions();
        
        }
        /////////////////// Vinh add and list transaction ///////////////////
        
        
        else {
            return;
        }
        }
    }
    public String toString(){
        return "Select An Account";
    }
}
