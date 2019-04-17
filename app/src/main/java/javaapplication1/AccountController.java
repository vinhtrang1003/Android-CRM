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
public class AccountController {
    private List<Account> accounts;
    private List<AccountMenuInterface> menuOptions;
    public AccountController() {
       accounts = new ArrayList<>();
       menuOptions = new ArrayList<>();
       menuOptions.add(new NewAccountMenu());
       menuOptions.add(new SelectAccountMenu());
       menuOptions.add(new ListAllAccount());
       
       /////////////////////Vinh Hard Code to make an Account //////////////
       Account Vinh;
       Vinh = new Account("vinhtrang1003", "School", "Hayward", "CA", "5106009094", "Vinh Trang");
       Vinh.newContact("A", "Mr", "5106009095", "A@yahoo.com");
       Vinh.newContact("B", "Ms", "5106009096", "B@yahoo.com");
       Vinh.newContact("C", "Ms", "5106009097", "C@yahoo.com");
       
       Vinh.addProduct("Computer","0310",599.99);
       Vinh.addProduct("TV","0311",1599.99);
       Vinh.addProduct("DVD","0312",5.99);
       
       accounts.add(Vinh);
       
    }
    
    public void execute(){
        Scanner scannerOject = new Scanner(System.in);  // Create a Scanner object
        int num = 0;
        System.out.println("Choose an option");
        for (AccountMenuInterface i: menuOptions){
            System.out.println( num + ". " + i );
            num++;
        }
        int option = scannerOject.nextInt();
        menuOptions.get(option).execute(accounts);
        
    }
}
