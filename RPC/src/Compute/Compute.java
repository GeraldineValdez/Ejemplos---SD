/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author usuario
 */
/*interface remoto permite que las tareas sean enviada al motor*/
public interface Compute extends Remote {
    
    Object executeTask(Task t) throws RemoteException;
    
}
