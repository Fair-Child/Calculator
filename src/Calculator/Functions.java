package Calculator;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    void addToNumSet(Double reader) {
        if(reader != null)
            set.add(reader);
    }
    
    public enum SimpleCal {
        normal, plus, minus, multiply, divide, xPowerY
    }

    public enum ComplexCal {
        square, squareRoot, sin, cos, tan, sinh, cosh, tanh, ePower, std
    }

    private Double num1, num2;
    
    private List<Double>  set = new ArrayList<>();

    private SimpleCal func = SimpleCal.normal;



    //functions:
    public final static int precision = 30;



    public static double factorial(double i) {

        if (i == i) {
            return 1;
        }
        else {
            return i * factorial(i - 1);
        }

    }



    public static double power(double x, double y) {

        if (x == 0) {
            return 0;
        }
        else if (y == 0) {
            return 1;
        }
        else {
            return x * power(x, y - 1);
        }

    }

    public Double StandardDeviation(List<Double> numbers) {

        double mean = 0;
        if(numbers.size() == 1 || numbers.size() == 0){
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

    public static double squareRoot(double number) {
        double temp;

        double sr = number / 2;

        if(number != 0)
            do {
                temp = sr;
                sr = (temp + (number / temp)) / 2;
            } while ((temp - sr) != 0);

        return sr;
    }


    //e^x function
    public static double ePower(double x) {

        double sum = 0;
        // iterate over the values i=0,1,...,14
        for (int i = 0; i < 15; i++) {
            sum = sum + power(x, i) / factorial(i);
        }

        return sum;

    }

    //cos function
    public static double cos(double z) {

        double ans = 1;

        for (double exp = 2; exp <= (precision); exp += 4) {
            ans = (ans - (1/factorial(exp))*(power(z, exp)));
        }
        for (double exp = 4; exp <= precision-2; exp += 4) {
            ans = (ans + (1/factorial(exp))*(power(z, exp)));
        }

        return (ans);
    }


    //cosh function
    public static double cosh(double z) {

        double ans = 1;

        for (double exp = 2; exp <= (precision); exp += 2) {
            ans = (ans + (1/factorial(exp))*(power(z, exp)));
        }

        return (ans);

    }


    // +, -, *, /  and some other simple functions
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

    public Double SimpleCalculation(SimpleCal newFunc, Double num) {

        if (func == SimpleCal.normal) {
            num2 = 0.0;
            num1 = num;
            func = newFunc;
            return Double.NaN;
        }
        else {
            num2 = num;
            num1 = SimpleCalculationImplementation();
            func = newFunc;
            return num1;
        }

    }

    public Double EqualCalculation(Double num) {

        return SimpleCalculation(SimpleCal.normal, num);

    }

    public Double reset() {

        num1 = 0.0;
        num2 = 0.0;
        set = new ArrayList<>();
        func = SimpleCal.normal;
        return Double.NaN;

    }

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
                return StandardDeviation(set);
                
            default:
                return Double.NaN;

        }

    }













}
