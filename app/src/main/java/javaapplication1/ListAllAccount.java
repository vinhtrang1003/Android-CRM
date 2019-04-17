/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC200
 */
public class ListAllAccount implements AccountMenuInterface {

    @Override
    public void execute(List<Account> acc) {
        
        int num = 0;
        for (Account i: acc){
            System.out.println(num + ". " + i.getAccountName());
            num++;
        }
    }
    
    public String toString(){
        return "List All Account";
    }
}
