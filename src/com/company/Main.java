package com.company;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        JSONArray array = new JSONArray();
        JSONObject jsonObject;
        JSONObject rates = new JSONObject();

        try {
            Object objNew  = parser.parse(new FileReader("./money.json"));
            array.add(objNew);
            jsonObject = (JSONObject) array.get(0);
            rates = (JSONObject) jsonObject.get("rates");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Available currencies: ");

        for (Object currency : rates.keySet()) {
            System.out.print(currency + " ");
        }

        System.out.print("\nType currency: ");
        Scanner inputCurrency = new Scanner(System.in);
        String currency = inputCurrency.nextLine();

        System.out.print("\nHow much: ");
        Scanner inputValue = new Scanner(System.in);
        double value = inputValue.nextDouble();

    }
}

