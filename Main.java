package com.company;

import java.util.Scanner;

// Interface to define abstract methods on the future investment class
interface InvestmentInputs{
    // abstract setter methods to change the investment value (input)
    abstract public void setInterestRate(double s);
    abstract public void setInvestment(double x);
    abstract public void setDuration (double y);

    // abstract method to calculate the future investment value.
    abstract public double calculateFutureInvestment ();
}

class FutureInvestment implements InvestmentInputs {
    // Define a,b and c as protected so as it can be accessed by this and child classes
    protected double a;
    protected double b;
    protected double c;
    // Constructor to define initial value of the input string
    FutureInvestment (double value) {
        a = value;
    }

    // Implement the abstract setter method to set a new string as input by overriding it
    @Override
    public void setInterestRate(double interest) {
        a = interest;
    }

    @Override
    public void setInvestment(double invest) {
        b = invest;
    }

    @Override
    public void setDuration(double years) {
        c = years;
    }

    // Implementing the core reverseString method by looping on the string in reverse;
//    @Override

    public double calculateFutureInvestment () {
        double interestRate = a;
        double investmentValue = b;
        double years = c;

        double futureInvestmentValue = investmentValue * Math.pow((1 + (interestRate / 12 )),(years * 12));
        return futureInvestmentValue;
    }
}

// Create Investment class that inherits from FutureInvestment class and adds a static method
// to scan values declared as double

class Investment extends FutureInvestment{
    Investment (double str){
        super(str);
    }

    public static double scanInterest() {
        Scanner sc = new Scanner(System.in);
        double interest = sc.nextDouble();

        return interest;
    }

    public static double scanInvestment() {
        Scanner sc = new Scanner(System.in);
        double invest = sc.nextDouble();

        return invest;
    }
    public static double scanDuration() {
        Scanner sc = new Scanner(System.in);
        double year = sc.nextDouble();

        return year;
    }
}

// Main application
class Main {
    public static void main (String[] args) {

        /* EXAMPLE 1 */
        double input = 24;
        // Using the constructor to initiate an instance with a value
        Investment ut = new Investment(input);


        // Capture input from the console using static method

        System.out.println("Enter investment number: ");
        double invest = Investment.scanInvestment();
        System.out.println("Enter interest rate: ");
        double interest = Investment.scanInterest();
        System.out.println("Enter investment number: ");
        double numberOfYears = Investment.scanDuration();

        // Set the scanned input as the input using setter and calculate the future investment
        ut.setInterestRate(interest);
        ut.setInvestment(invest);
        ut.setDuration(numberOfYears);
        double futureInvestment = ut.calculateFutureInvestment();

        // Print the investment value output to console

        System.out.println("Output future investment value: " + futureInvestment);
        System.out.println("------------------------------------");
    }
}