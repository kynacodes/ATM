package com.kyna.javaprograms;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingsBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /* Set the account number */

    public int setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
        return accountNumber;
    }

    /* Get the account number */

    public int getAccountNumber(){
        return accountNumber;
    }

    /* Set the PIN number */

    public int setPin(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* Get the PIN number */

    public int getPin(){
        return pinNumber;
    }

    /* Get checking account balance */

    public double getCheckingBalance(){
        return checkingBalance;
    }

    /* Get savings account balance */

    public double getSavingsBalance(){
        return savingsBalance;
    }

    /* Calculate checking account withdrawal */

    public double calcCheckingWithdrawal(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    /* Calculate savings account withdrawal */

    public double calcSavingsWithdrawal(double amount){
        savingsBalance = (savingsBalance - amount);
        return savingsBalance;
    }

    /* Calculate Checking Account Deposit */

    public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    /* Calculate Savings Account Deposit */

    public double calcSavingsDeposit(double amount){
        savingsBalance = (savingsBalance + amount);
        return savingsBalance;
    }

    /* Get customer checking account withdrawal amount */

    public void getCheckingWithdrawalAmount(){
        System.out.println("Current Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("How much would you like to withdraw from checking? ");
        double amount = input.nextDouble();

        if((checkingBalance - amount) >= 0){
            calcCheckingWithdrawal(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Insufficient funds for withdrawal." + "\n");
        }
    }

    /* Get customer savings account withdrawal amount */

    public void getSavingsWithdrawalAmount(){
        System.out.println("Current Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("How much would you like to withdraw from savings? ");
        double amount = input.nextDouble();

        if((savingsBalance - amount ) >= 0){
            calcSavingsWithdrawal(amount);
            System.out.println("New Savings Account Balance: " + moneyFormat.format(savingsBalance));
        }else System.out.println("Insufficient funds for withdrawal." + "\n");
    }

    /*Customer Checking Account Deposit amount */

    public void getCheckingDepositAmount(){
        System.out.println("Current Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("How much would you like to deposit into your checking account?");
        double amount = input.nextDouble();

        if((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else{
            System.out.println("Error. Balance cannot be negative." + "\n");
        }
    }

    /* Customer Savings Account Deposit amount */

    public void getSavingsDepositAmount(){
        System.out.println("Current Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("How much would you like to deposit into your savings account?");
        double amount = input.nextDouble();

        if((savingsBalance + amount) >= 0) {
            calcSavingsDeposit(amount);
            System.out.println("New Savings Account Balance: " + moneyFormat.format(savingsBalance));
        } else{
            System.out.println("Error. Balance cannot be negative." + "\n");
        }
    }




}
