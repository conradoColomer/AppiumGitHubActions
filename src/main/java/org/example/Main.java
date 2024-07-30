package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String apiKey = System.getenv("API_KEY");


        System.out.println(apiKey);

        int[] numbers = {1, 2, 3, 4, 5};

        for ( int num : numbers) {
            System.out.println(num);

        }


    }
}