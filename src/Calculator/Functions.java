package Calculator;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    void addToNumSet(Double reader) {
        if (reader != null) {
            set.add(reader);
        }
    }

    public enum SimpleCal {
        normal, plus, minus, multiply, divide, xPowerY
    }

    public enum ComplexCal {
        square, squareRoot, sin, cos, tan, sinh, cosh, tanh, ePower, std, piPower
    }

    private Double num1, num2;

    private List<Double> set = new ArrayList<>();

    private SimpleCal func = SimpleCal.normal;



    //functions:
    public final static int precision = 30;


    /**
     * The simple calculation function
     *
     * @author Hong Fei Liang
     * @return the result of simple calculation
     */
    private Double SimpleCalculationImplementation() {

        switch (func) {

            case normal:
                return num2;

            case plus:
                return num1 + num2;

            case minus:
                return num1 - num2;

            case multiply:
                return num1 * num2;

            case divide:
                return num1 / num2;

            case xPowerY:
                return Math.pow(num1, num2);

            default:
                return -1.0;

        }

    }

    /**
     * The function calls SimpleCalculationImplementation to implement: normal, plus, minus, multiply, divide, xPowerY
     *
     * @author Hong Fei Liang
     * @param newFunc enum function name that user want to use
     * @param num the input number
     * @return the result of SimpleCalculationImplementation
     */
    public Double SimpleCalculation(SimpleCal newFunc, Double num) {

        if (func == SimpleCal.normal) {
            num2 = 0.0;
            num1 = num;
            func = newFunc;
            return Double.NaN;
        } else {
            num2 = num;
            num1 = SimpleCalculationImplementation();
            func = newFunc;
            return num1;
        }

    }

    /**
     * The warp function for SimpleCalculation
     *
     * @author Hong Fei Liang
     * @param num the input number
     * @return the result of SimpleCalculation
     */
    public Double EqualCalculation(Double num) {

        return SimpleCalculation(SimpleCal.normal, num);

    }

    /**
     * The function to clean up all of the memory of calculator
     *
     * @author Hong Fei Liang
     * @return a empty memory for next calculation
     */
    public Double reset() {

        num1 = 0.0;
        num2 = 0.0;
        set = new ArrayList<>();
        func = SimpleCal.normal;
        return Double.NaN;

    }

    /**
     * This function is used then user clicked on response buttons: square, squareRoot, sin, cos, tan, sinh, cosh, tanh, ePower, std, piPower
     *
     * @author Hong Fei Liang
     * @param newFunc enum function name that user wants to use
     * @param num the number passed in
     * @return the result after calculation
     */
    public Double ComplexCalculation(ComplexCal newFunc, Double num) {
        //square, squareRoot, sin, cos, tan, sinh, cosh, tanh, ePower, x^y
        switch (newFunc) {


            case square:
                return num * num;

            case squareRoot:
                return Math.sqrt(num);

            case sin:
                return Math.sin(num);

            case cos:
                return cos(num);

            case tan:
                return Math.tan(num);

            case sinh:
                return Math.sinh(num);

            case cosh:
                return cosh(num);

            case tanh:
                return Math.tanh(num);

            case ePower:
                return ePower(num);

            case std:
                return standardDeviation(set);

            case piPower:
                return piCal(num);

            default:
                return Double.NaN;

        }

    }

    /**
     * A simple recursive factorial function, to be used as a helper function.
     *
     * @author Sean Goharzadeh
     * @param i The base.
     * @return The factorial of the double i passed into the function.
     */
    public static double factorial(double i) {

        if (i == i) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }

    }

    /**
     * A simple recursive power function for integers, to be used a helper function.
     *
     * @author Sean Goharzadeh
     * @param x The base.
     * @param y The exponent.
     * @return x to the power of y.
     */
    public static double power(double x, double y) {

        if (x == 0) {
            return 0;
        } else if (y == 0) {
            return 1;
        } else {
            return x * power(x, y - 1);
        }

    }

    /**
     * Returns the standard deviation of a data sample that is given to the function in the form of a list of doubles
     *
     * @author Tahar Mustapha
     * @param  numbers list containing the sample data
     * @return standard deviation of sample data
     */
    public Double standardDeviation(List<Double> numbers) {

        double mean = 0;
        if (numbers.size() == 1 || numbers.size() == 0) {
            return 0.0;
        }
        for (double number : numbers) {
            mean += number;
        }
        mean = mean / numbers.size();
        double sum = 0;
        for (double number : numbers) {
            sum = sum + (number - mean) * (number - mean);
        }
        double standardDev = squareRoot(sum / numbers.size());

        return standardDev;
    }

    /**
     * Returns the square root of a any given double. The input is simply the number on which the square root function will be performed This function is used as a helper function for calculation the standard deviation
     *
     * @author Tahar Mustapha
     * @param  number  double that will be square rooted
     * @return the result of the square root
     */
    public static double squareRoot(double number) {
        double temp;

        double sr = number / 2;

        if (number != 0) {
            do {
                temp = sr;
                sr = (temp + (number / temp)) / 2;
            } while ((temp - sr) != 0);
        }

        return sr;
    }

    /**
     * This calculates the exponential function by integrating the power and factorial helper functions in an infinite expansion series. The series iterates 15 times, which gives it a decent precision.
     *
     * @author Vishal Senewiratne
     * @param x the value of the power given to the function
     * @return the sum of the infinite series
     */
    public double ePower(double x) {

        double sum = 0;
        // iterate over the values i=0,1,...,14
        for (int i = 0; i < 15; i++) {
            sum = sum + power(x, i) / factorial(i);
        }

        return sum;

    }

    /**
     * Cosine method. Calculates the cosine of a given number, in radians, with 17 decimal precision.
     *
     * @author Sean Goharzadeh
     * @param z The double for which the cosine must be calculated.
     * @return The cosine of z.
     */
    public static double cos(double z) {

        double ans = 1;

        for (double exp = 2; exp <= (precision); exp += 4) {
            ans = (ans - (1 / factorial(exp)) * (power(z, exp)));
        }
        for (double exp = 4; exp <= precision - 2; exp += 4) {
            ans = (ans + (1 / factorial(exp)) * (power(z, exp)));
        }

        return (ans);
    }

    /**
     * Cosh method. Calculates the cosh of a given number, in radians, with 17 decimal precision.
     *
     * @author Hong Fei Liang
     * @param z The double for which the cosh must be calculated.
     * @return The cosh of z.
     */
    public static double cosh(double z) {

        double ans = 1;

        for (double exp = 2; exp <= (precision); exp += 2) {
            ans = (ans + (1 / factorial(exp)) * (power(z, exp)));
        }

        return (ans);

    }

    /**
     * π^x method. Calculates the π^x of a given number
     *
     * @author Alan Fok
     * @param input is double for which the exponent of π must be calculated.
     * @return The π^x of input.
     */
    public double piCal(double input) {
        double pi = (double) 3.14159; //pi number
        double temp = 1;
        double temp4 = 1;
        double sqrtroot = 0;
        int exp = 0;
        double root = 0;

        if (input == 0) {
            //every thing exponent with 0 will be equal 1
            return temp;
        } else if (input > 0)//if the exponent is positive number
        {
            double reminder = input % 1;

            for (int i = 0; i < (int) input; i++) {
                temp = temp * pi;
            }//end for

            if (reminder != 0) //It is not int number
            {
                double z = Double.parseDouble(String.format("%.7f", reminder));
                sqrtroot = tenExpByPi(z);
                exp = checkDecOfInupt(z);
                root = power_sqrt(pi, (int) sqrtroot);
                for (int i = 0; i < exp; i++) {
                    temp4 = temp4 * root;
                }
                temp = temp * temp4;
            }
            return temp;
        }//end else
        else //if the exponent is negative number
        {
            input = 0 - input;
            double reminder = input % 1;

            for (int i = 0; i < (int) input; i++) {
                temp = temp * pi;
            }//end for

            if (reminder != 0) //It is not int number
            {
                double z = Double.parseDouble(String.format("%.7f", reminder));
                sqrtroot = tenExpByPi(z);
                exp = checkDecOfInupt(z);
                root = power_sqrt(pi, (int) sqrtroot);
                for (int i = 0; i < exp; i++) {
                    temp4 = temp4 * root;
                }
                temp = temp * temp4;
            }
            return 1 / temp;
        }
    }

    /**
     * This function of use to convert decimal value to integer.
     *
     * @author Alan Fok
     * @param  input of input number
     * @return value of integer (1 if input is 0.1, 12 if input is 0.12)
     */
    public int checkDecOfInupt(double input) {
        double temp_input = input;
        while (temp_input % 10 != 0) {
            temp_input = Double.parseDouble(String.format("%.7f", temp_input));
            temp_input *= 10;
        }
        temp_input /= 10;
        return (int) temp_input;
    }

    /**
     * This function of use to calculate the decimal exponent value.
     *
     * @author Alan Fok
     * @param  input of input number after decimal (0.1 if input is 3.1, 0.12 if input is 3.12)
     * @return  decimal exponent value (10 if input is 0.1, 100 if input is 0.12)
     */
    public double tenExpByPi(double input) {
        double temp_input = input;
        int denom = 1;
        while (temp_input % 10 != 0) {
            temp_input = Double.parseDouble(String.format("%.7f", temp_input));
            temp_input *= 10;
            denom *= 10;
        }
        denom /= 10;
        return denom;
    }

    /**
     * This function of use to calculate the nth square root.
     *
     * @author Alan Fok
     * @param  exp for the exponent
     * @param  ori for the base
     * @return the calculated output of a nth square root
     */
    public double power_sqrt(double ori, int exp) {
        double max = (double) 500.00000000;
        double min = (double) 0.00000000;
        double mid = (double) 0.00000000;
        double temp = (double) 1;
        boolean big_check = false;
        for (int i = 0; i < 60; i++) {
            mid = (max + min) / 2;
            temp = 1;
            big_check = false;
            for (int j = 0; j < exp; j++) {
                temp = temp * mid;
                if (temp > ori) {
                    max = mid;
                    big_check = true;
                    break;
                }
            }
            if (!big_check) {
                min = mid;
            }
        }
        return mid;
    }

}
