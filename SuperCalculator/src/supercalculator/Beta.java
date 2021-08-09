/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalculator;

import static supercalculator.CalculatorUtils.getOutput;
import static supercalculator.CalculatorUtils.printInvalidDomain;

/**
 * Class use to calculate the Beta function of two integers bigger than 0
 * @author za
 */
public class Beta {

    private int inputValue1;
    private int inputValue2;
    
    /**
     * Constructor takes the two Integer values use to calculate the Beta function
     * @param input1 First Integer value to calculate the beta function
     * @param input2 Second Integer value to calculate the beta function
     */
    public Beta(int input1, int input2){
        inputValue1 = input1;
        inputValue2 = input2;
    }
    
    /**
     *
     * @return True if the domain is within the admissible domain range. Otherwise False.
     */
    public boolean isValidDomain(){    
        
        return !(inputValue1 < 0 || inputValue2 < 0);
    }
    
    /**
     * Prints a message on the screen with the calculation of the beta function.
     * It also prints whether the domain is invalid or the the return value is not a valid number.
     */
    public void calculateInUi(){

        try{
            getOutput(calculate());
        }
        catch( InvalidDomainException e){
            
            printInvalidDomain("Invalid Domain, try again");
        }
    }
    
    /**
     *
     * @return A double precision number with the result of the Beta function
     * @throws InvalidDomainException
     */
    public double calculate() throws InvalidDomainException{
        
        if(!isValidDomain()){
            throw new InvalidDomainException("Beta Does not accept negative intergers");
        }

        Double factor1 = Math.calculateFactorial(inputValue1 - 1);
        Double factor2 = Math.calculateFactorial(inputValue2 - 1);
        Double factor3 = Math.calculateFactorial(inputValue1 +inputValue2 - 1);
        
        Double result = Double.NaN;
        
        try{
            
            if (factor3 == 0){
                
                if( (factor1) == 0 || (factor2) == 0){
                    
                    return Double.NaN;
                }
                else if( factor1 * factor2 > 0 ){
                    
                    return Double.POSITIVE_INFINITY;
                }
                else if( factor1 * factor2 < 0){
                    
                    return Double.NEGATIVE_INFINITY;
                }
            }
            else{
                
            }
            
            result = (factor1 * factor2) / factor3;
            
        }
        catch (ArithmeticException ae) {
            
            System.out.println("ArithmeticException occured!");
            result = Double.POSITIVE_INFINITY;
        }

        return result;
    }
}
