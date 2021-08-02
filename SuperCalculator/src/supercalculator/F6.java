/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalculator;

/**
 *
 * @author za
 */
public class F6 {

    private int _x;
    private int _y;
    
    public F6(int x, int y){
        _x = x;
        _y = y;
    }
    
    public boolean isValidDomain(){    
        //use _x and _y
        return true;
    }
    
    public double calculate(){
        return Math.factorial(_x-1)*Math.factorial(_y-1)/Math.factorial(_x+_y-1);
    }
}
