package com.epam.pashkov.parsers;

/**
 * Created by Yaroslav on 07.05.2015.
 */

import com.epam.pashkov.Bank;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateJSONFile {
    public static void create() {
        Bank bank = new Bank();
        Bank.Deposit d = bank.new Deposit("name0",
                                            "Ukraine",
                                            "Type0",
                                            "Depositor0",
                                            "AccountId0",
                                            "AmountOnDeposit0",
                                            "Profitability0",
                                            "TimeConstraints0");

        JSONArray depositArray = new JSONArray();
        JSONObject deposit0 = new JSONObject();
        deposit0.put("name", d.getName());
        deposit0.put("country", d.getCountry());
        deposit0.put("type", d.getType());
        deposit0.put("depositor", d.getDepositor());
        deposit0.put("accountId", d.getAccountId());
        deposit0.put("amountOnDeposit", d.getAmountOnDeposit());
        deposit0.put("profitability", d.getProfitability());
        deposit0.put("timeConstraints", d.getTimeConstraints());

        depositArray.add(deposit0);

        JSONObject objBank = new JSONObject();
        objBank.put("deposit", depositArray);

        JSONObject rootObj = new JSONObject();
        rootObj.put("bank", objBank);

        File file = new File("createdJsonFile.json");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(rootObj);
                System.out.println("File was created.");
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
