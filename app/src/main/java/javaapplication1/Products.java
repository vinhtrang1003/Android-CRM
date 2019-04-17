/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.Serializable;

/**
 *
 * @author Vinh
 */
public class Products implements Serializable
{
    private String productName;
    private String productID;
    private double productPrice;
    
    
    public Products (String pname, String pid, double pprice)
    {
        productName = pname;
        productID = pid;
        productPrice = pprice;
    }
    
    public String getpname()
    {
        return productName;
    }
    
    public String getpid()
    {
        return productID;
    }
      
    public double getpprice()
    {
        return productPrice;
    }
        
    public void setpprice( double p)
    {
        productPrice = p;
    }
    
     public void setID( String id)
    {
        productID = id;
    }
    
    
    
    
}
