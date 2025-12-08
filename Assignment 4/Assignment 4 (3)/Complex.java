public class Complex {
    // A complex number has form: real + imaginary*i
    private double real;
    private double imaginary;

    // Constructor
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Display the complex number
    public String toString() {
        if (imaginary >= 0)
            return real + " + " + imaginary + "i";
        else
            return real + " - " + (-imaginary) + "i";
    }
}