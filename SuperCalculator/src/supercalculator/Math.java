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
public class Math {
    
    public static double factorial(int n){
        
        if(n == 0 || n == 1){
            return 1.0d;
        }
        
        double result = n * factorial(n-1);
        return result;
    }
    
}
