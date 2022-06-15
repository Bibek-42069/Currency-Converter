package com;

import java.util.Scanner;

public class Machine {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();

    private void ConvertCurrency(){
        System.out.println("---All Convertible Currencies---");
        converter.PrintValidCurrency();
        System.out.println("--------------------------------");

        System.out.println("What currency is the input?");
        String inputCurrencyString = scanner.next();

        while (!converter.validifyCurrentCurrency(inputCurrencyString)){
            System.out.println("Invalid! Select a currency from the list!");
            inputCurrencyString = scanner.next();
        }

        System.out.println("What currency is the output?");

        String outputCurrencyString = scanner.next();

        while (!converter.validifyCurrentCurrency(outputCurrencyString)){
            System.out.println("Invalid! Select a currency from the list!");
            outputCurrencyString = scanner.next();
        }

        Currency outputCurrency = converter.StringToCurrency(outputCurrencyString);
        Currency inputCurrency = converter.StringToCurrency(inputCurrencyString);

        System.out.println("How much is the input?");

        float inputVal = scanner.nextFloat();

        System.out.println(converter.convert(inputVal,inputCurrency,outputCurrency));

    }

    private void AddCurrency(){
        System.out.println("Currency Name?");

        String name = scanner.next();

        while (!converter.validifyNewCurrency(name)){
            System.out.println("Invalid! Please pick a currency not already in the system!");
            name = scanner.next( );
        }

        System.out.println("Whats it value compared to usd?");

        float value = scanner.nextFloat();

        converter.AddNewCurrency(name,value);
    }

    public void StartMachine(){
        System.out.println("Welcome to The Currency Converter!");

        while (true){
            System.out.println("Please pick an option (1/2/3)!\n1. Add a currency\n2. Convert currency\n3. exit");
            String machineState = scanner.next();

            if(machineState.equals("1"))
                AddCurrency();
            else if(machineState.equals("2"))
                ConvertCurrency();
            else if(machineState.equals("3"))
                break;
        }
    }
}
