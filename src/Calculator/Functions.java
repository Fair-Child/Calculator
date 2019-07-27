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

//    public enum EqualCalculation {
//        simple, ePower, piPower
//    }

    public enum ComplexCal {
        square, squareRoot, sin, cos, tan, sinh, cosh, tanh, ePower, std, piPower
    }

    private Double num1, num2;

    private List<Double> set = new ArrayList<>();

    private SimpleCal func = SimpleCal.normal;



    //functions:
    public final static int precision = 30;



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
        } else {
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
                return standardDeviation(set);

            case piPower:
                return piCal(num);

            default:
                return Double.NaN;

        }

    }





    public static double factorial(double i) {

    	if (i > 1) {
			return i * factorial(i - 1);
		} else {
			return 1;
		}

    }

    public static double power(double x, double y) {

    	double ret = 1;

		// iterate over the values i=1,...,n.
		for (int i = 1; i <= y; i++) {
			// multiply factorial by each value of i.
			ret = ret * x;
		}

		return ret;
    }

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

    //e^x function
    public double ePower(double x) {

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
            ans = (ans - (1 / factorial(exp)) * (power(z, exp)));
        }
        for (double exp = 4; exp <= precision - 2; exp += 4) {
            ans = (ans + (1 / factorial(exp)) * (power(z, exp)));
        }

        return (ans);
    }

    //cosh function
    public static double cosh(double z) {

        double ans = 1;

        for (double exp = 2; exp <= (precision); exp += 2) {
            ans = (ans + (1 / factorial(exp)) * (power(z, exp)));
        }

        return (ans);

    }





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

    public int checkDecOfInupt(double input) {
        double temp_input = input;
        while (temp_input % 10 != 0) {
            temp_input = Double.parseDouble(String.format("%.7f", temp_input));
            temp_input *= 10;
        }
        temp_input /= 10;
        return (int) temp_input;
    }

    public int checkDecOfDenom(double input) {
        double temp_input = input;
        int denom = 1;
        while (temp_input % 10 != 0) {
            temp_input *= 10;
            denom *= 10;
        }
        denom /= 10;

        return denom;
    }

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
