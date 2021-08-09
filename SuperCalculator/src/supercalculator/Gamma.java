import java.util.*;

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
    public static double real;
    public static double imaginary;

    public static double simpleGamma(){
        double y;
        if(real < 0.5){
            //reflection formula according to Lanczos approximation
            real -= 1;
            y = PI / (Math.sin(PI*real) * simpleGamma());
        }
        else {
            real -= 1;
            double x = 0.99999999999980993;
            for (int i = 0; i < p.length; i++) {
                x += p[i] / (real + i + 1);
            }
            double t = real + p.length - 0.5;
            y = Math.sqrt(2 * PI) * MyMath.calculatePower(t,real + 0.5) * Math.exp(-t) * x;
        }
        return y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Select one of the following options for the type of number: \n" +
                    "1. real number\n" +
                    "2. imaginary number\n" +
                    "3. complex number\n" +
                    "4. Quit");
            int option = in.nextInt();
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
            double result = real;
            if(real > 0)
                result = simpleGamma();
            else
                System.out.println("Number has to be a positive real or complex number");
            if (imaginary <= EPSILON)
                System.out.println(result);
            else
                System.out.println(result + " + " + imaginary);
        }
    }

}
