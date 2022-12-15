import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs){
        this.coeffs = coeffs;
    }

    public MyPolynomial(String filename){
        Scanner in = null;
        try{
            in = new Scanner(new File(filename));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        int degree = in.nextInt();
        coeffs = new double[degree+1];
        for(int i=0; i < coeffs.length; ++i){
            coeffs[i] = in.nextDouble();
        }
    }

    public int getDegree(){
        int degree = coeffs.length - 1;
        return degree;
    }

    public String toString(){
        String s = "";
        for(int i = coeffs.length - 1; i >= 0; i--){
            s += String.valueOf(coeffs[i]);
            if(i > 1){
                s += "x^" + i + " + ";
            }
            if(i == 1){
                s += "x + ";
            }
        }
        return s;
    }

    public double evaluate(double x){
        double result = coeffs[0];
        for(int i = 1; i < coeffs.length; i++){
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial p){
        double[] result;
        double[] another = p.coeffs;
        if(coeffs.length >= another.length){
            result = new double[coeffs.length];
            for(int i = 0; i < result.length; i++){
                if(i > another.length - 1){
                    result[i] = coeffs[i];
                }
                else{
                    result[i] = coeffs[i] + another[i];
                }
            }
        }
        else{
            result = new double[another.length];
            for(int i = 0; i < result.length; i++){
                if(i > coeffs.length - 1){
                    result[i] = another[i];
                }
                else{
                    result[i] = another[i] + coeffs[i];
                }
            }
        }

        MyPolynomial addition = new MyPolynomial(result);
        return addition;
    }

    public MyPolynomial multiply(MyPolynomial p){
        double[] another = p.coeffs;
        double[] result = new double[coeffs.length + another.length - 1];
        for(int i = 0; i < coeffs.length; i++){
            for(int j = 0; j < another.length; j++){
                result[i+j] += coeffs[i] * another[j];
            }
        }
        MyPolynomial multiplication = new MyPolynomial(result);
        return multiplication;
    }
}