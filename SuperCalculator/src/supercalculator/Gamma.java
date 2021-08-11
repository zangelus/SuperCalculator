package supercalculator;


/**
 * Gamma class
 * @author Nneamaka Adirika
 *
 *
 * 2021-08-09
 *
 * Gamma function for super calculator SOEN 6011
 */
public class Gamma {
    public static final double[] p = {676.5203681218851
            ,-1259.1392167224028
            ,771.32342877765313
            ,-176.61502916214059
            ,12.507343278686905
            ,-0.13857109526572012
            ,9.9843695780195716e-6
            ,1.5056327351493116e-7};
    public static final double EPSILON = 1e-07;
    public static final double PI = 3.141592653589793;
    public static final double E = 2.718281828459045;
    public static double real;
    public static double imaginary;

    /**
     * Default constructor
     */
    public Gamma(){}

    /**
     * Parameterized constructor
     */
    public Gamma(double r, double i){
        real = r;
        imaginary = i;
    }

    /**
     * This function calculates the gamma value for a real or complex number from user.
     * This is calculated by applying Lanczos approximation
     * It is invoked in the getInput method below
     * @return A double representing the gamma of the input value
     */
    public static double simpleGamma(){
        double y;
        if(real < 0.5 && real > 0){
            //reflection formula according to Lanczos approximation
            real -= 1;
            y = PI / (Math.sine(PI*real) * simpleGamma());
        }
        else {
            real -= 1;
            double x = 0.99999999999980993;
            for (int i = 0; i < p.length; i++) {
                x += p[i] / (real + i + 1);
            }
            double t = real + p.length - 0.5;
            y = Math.squareRoot(2 * PI) * Math.calculatePower(t,real + 0.5) * Math.calculatePower(E,-t) * x;
        }
        return y;
    }

    /**
     * This method is invoked from the supercalculator.SuperCalculator class
     * It then collects user value for a number, calculates the gamma value and displays the result to the user.
     * @param in Scanner class initiated in the supercalculator.SuperCalculator class.
     */
    public static void getInput(Scanner in) {
        try {
            //Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("Select one of the following options for the type of number: \n" +
                        "1. real number\n" +
                        "2. imaginary number\n" +
                        "3. complex number\n" +
                        "4. Quit");
                int option = in.nextInt();
                if(option < 1 || option > 4) {
                    System.out.println("Number has to be between 1 and 4");
                    continue;
                }
                switch (option) {
                    case 1:
                        System.out.println("Enter a real number:");
                        real = in.nextDouble();
                        imaginary = 0;
                        break;
                    case 2:
                        System.out.println("Enter an imaginary number:");
                        imaginary = in.nextDouble();
                        real = 0;
                        break;
                    case 3:
                        System.out.println("Enter the real part of the number:");
                        real = in.nextDouble();
                        System.out.println("Enter the imaginary part of the number:");
                        imaginary = in.nextDouble();
                        break;
                    case 4:
                        System.exit(0);
                }
                double result;
                if (real < 0)
                    System.out.println("Number has to be a positive real or complex number");

                else {
                    result = simpleGamma();
                    CalculatorUtils.getOutput(result);

                    //if (imaginary <= EPSILON)
                    //  CalculatorUtils.printInvalidDomain(result+"");
                    //else
                    //  CalculatorUtils.printInvalidDomain(result + " + " + imaginary + "i");

                }
            }
        }catch (InputMismatchException e){
            System.out.println("Input not allowed, it has to be a positive number.");
        }
    }

}
