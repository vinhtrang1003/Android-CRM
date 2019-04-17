/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Vinh
 */
public class Transaction 
{
    private String CustomerName;
    private String ProductName;
    
    private String ProductID;
    private int Quality;
    
    public String TransactionID;
    Calendar DatePurchased;
    
    

    public Transaction(String id) 
    {
        TransactionID = id;
    }
    
    public String getCName() 
    {
        return CustomerName;
    }
     public String getPName() 
    {
        return ProductName;
    }
      public String getPID() 
    {
        return ProductID;
    }
      public String getTID() 
    {
        return TransactionID;
    }
      public int getQuality() 
    {
        return Quality;
    }
      public Calendar getDate() 
    {
        return DatePurchased;
    }
    
    public void CreateTransaction(Contact CContact, Products P, String TID, int Q)
    {
        Calendar today = new GregorianCalendar();
        int thisYear = today.get(Calendar.YEAR),
            thisMonth = today.get(Calendar.MONTH),
            thisDay = today.get(Calendar.DAY_OF_MONTH);
        
        CustomerName = CContact.getName();
        ProductName = P.getpname();
        ProductID = P.getpid();
        
        TransactionID = TID;
        Quality = Q;
        
        DatePurchased = today;
    }
    
    
    
    
    
    
    
}