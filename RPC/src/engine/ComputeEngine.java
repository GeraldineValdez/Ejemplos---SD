/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import Compute.Compute;
import Compute.Task;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author usuario
 */
public class ComputeEngine extends UnicastRemoteObject implements Compute {
    
    public ComputeEngine()throws RemoteException
    {
        super();
    }
    
    public Object executeTask(Task t)
    {
        return t.execute();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if(System.getSecurityManager() == null)
        {
            System.setSecurityManager(new RMISecurityManager());
        }
        
        String name = "//localhost/Compute";
        
        try
        {
            Compute engine = new ComputeEngine();
            Naming.rebind(name, engine);
            System.out.println("ComputeEngine bound");
        }
        catch(Exception e)
        {
            System.err.println("ComputeEngine exception:"+ e.getMessage());
            e.printStackTrace();
        }
    }
}
