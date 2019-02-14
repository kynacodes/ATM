package com.kyna.javaprograms;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class OptionMenu extends Account{
        Scanner menuInput = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("'$'####,##0.00");

        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

        /*Validate login information, customer number, and PIN number*/

        public void getLogIn() throws IOException {
            int x = 1;

            do {
                try {

                    data.put(12345, 54321);
                    data.put(98765, 56789);

                    System.out.println("Welcome to the ATM!");
                    System.out.println("Please enter your account number:  ");
                    setAccountNumber(menuInput.nextInt());

                    System.out.println("Please enter your PIN: ");
                    setPin(menuInput.nextInt());
                } catch (Exception e) {
                    System.out.println("\n" + "Invalid entry. Please enter numbers only." + "\n");
                    x = 2;
                }

                Integer validPin = data.get(getAccountNumber());
                if (validPin != null && validPin.equals(getPin())) {
                    getAccountType();
                }
                else {
                    System.out.println("Incorrect account number or PIN number.");
                }

//                for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
//                    if ((entry.getKey() == getAccountNumber()) && (entry.getValue() == getPin())) {
//                        getAccountType();
//                    }
//                }


            } while (x == 1);
        }


        /* Display Account Type Menu options */

        public void getAccountType(){
            System.out.println("Which account would you like to access? (Or select 3 to exit)");
            System.out.println("1: Checking");
            System.out.println("2: Savings");
            System.out.println("3: Exit");
            System.out.println("Selection: ");

            selection = menuInput.nextInt();

            switch(selection){
                case 1:
                    getChecking();
                    break;
                case 2:
                    getSavings();
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM! Have a great day!");
                    break;
                default:
                    System.out.println("\n" + "Invalid selection. Please try again: " + "\n");
                    getAccountType();
            }
        }

        /* Display Checking Account Menu options */

        public void getChecking(){
            System.out.println("Checking Account Options: ");
            System.out.println("1: View balance");
            System.out.println("2: Make a withdrawal");
            System.out.println("3: Make a deposit");
            System.out.println("4: Exit");
            System.out.println("What would you like to do? ");

            selection = menuInput.nextInt();

            switch(selection){
                case 1:
                    System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                    getAccountType();
                    break;
                case 2:
                    getCheckingWithdrawalAmount();
                    getAccountType();
                    break;
                case 3:
                    getCheckingDepositAmount();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM! Have a great day!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    getChecking();

            }
        }

        /* Display Savings Account Menu options */

        public void getSavings(){
            System.out.println("Savings Account options: ");
            System.out.println("1: View balance");
            System.out.println("2: Make a withdrawal");
            System.out.println("3: Make a deposit");
            System.out.println("4: Exit");

            selection = menuInput.nextInt();

            switch(selection){
                case 1:
                    System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingsBalance()));
                    getAccountType();
                    break;
                case 2:
                   getSavingsWithdrawalAmount();
                   getAccountType();
                   break;
                case 3:
                    getSavingsDepositAmount();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM! Have a great day!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    getSavings();
            }
        }

        int selection;
    }