/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Compute.Compute;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 *
 * @author usuario
 */
public class ComputePi {
    
    public static void main (String [] args) throws NotBoundException, MalformedURLException, RemoteException
    {
        if(System.getSecurityManager() == null)
        {
            System.setSecurityManager(new RMISecurityManager());
        }
        
        try
        {
            String name = "//" +args[0]+ "/Compute";
            Compute comp = (Compute) Naming.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1]));
            BigDecimal pi = (BigDecimal)(comp.executeTask(task));
            System.out.println(pi);
        }
        catch(Exception e)
        {
            System.err.println("ComputePi exception:" + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
