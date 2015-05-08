package com.epam.pashkov.parsers;

import com.epam.pashkov.Bank;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by Yaroslav on 07.05.2015.
 */
public class ParserJSON {
    public static ArrayList<Bank.Deposit> parse() {
        ArrayList<Bank.Deposit> depositsList = new ArrayList<Bank.Deposit>();
        Bank bank = new Bank();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(new File("deposits.json")));
            JSONObject jsonBaseObj = (JSONObject) obj;
            JSONObject jsonBankObj = (JSONObject) jsonBaseObj.get("bank");

            JSONArray arrayOfDeposits = (JSONArray) jsonBankObj.get("deposit");

            for(int i = 0; i<arrayOfDeposits.size();i++){
                JSONObject jo = (JSONObject) arrayOfDeposits.get(i);
                depositsList.add(bank.new Deposit(jo.get("name").toString(),
                        jo.get("country").toString(),
                        jo.get("type").toString(),
                        jo.get("depositor").toString(),
                        jo.get("accountId").toString(),
                        jo.get("amountOnDeposit").toString(),
                        jo.get("profitability").toString(),
                        jo.get("timeConstraints").toString()));
            }
        }
        catch (Exception e) {
            e.getMessage();
        }

        return depositsList;
    }
}
