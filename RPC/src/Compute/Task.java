/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compute;

import java.io.Serializable;

/**
 *
 * @author usuario
 * 
 * 
 */
public interface Task extends Serializable{
    
    Object execute();
    
}
