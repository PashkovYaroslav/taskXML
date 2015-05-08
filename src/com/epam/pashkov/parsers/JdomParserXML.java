package com.epam.pashkov.parsers;

import com.epam.pashkov.Bank;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom.*;
import org.jdom.input.*;

/**
 * Created by Yaroslav_Pashkov on 5/7/2015.
 */
public class JdomParserXML {
    public static ArrayList<Bank.Deposit> parse(){
        ArrayList<Bank.Deposit> depositsList = new ArrayList<Bank.Deposit>();
        Bank bank = new Bank();

        try {
            SAXBuilder parser = new SAXBuilder();
            FileReader fr = new FileReader("deposits.xml");
            Document rDoc = parser.build(fr);

            List<Element> depositsMainList = rDoc.getRootElement().getChildren();
            for (int i = 0; i < depositsMainList.size(); ++i) {
                List<Element> depositInfoList = depositsMainList.get(i).getChildren();
                Bank.Deposit deposit = bank.new Deposit();
                for(int j = 0; j<depositInfoList.size(); j++){
                    if(depositInfoList.get(j).getName().equals("name")) {
                        deposit.setName(depositInfoList.get(j).getValue());
                    }

                    else if(depositInfoList.get(j).getName().equals("country")) {
                        deposit.setCountry(depositInfoList.get(j).getValue());
                    }

                    else if(depositInfoList.get(j).getName().equals("type")) {
                        deposit.setType(depositInfoList.get(j).getValue());
                    }

                    else if(depositInfoList.get(j).getName().equals("depositor")) {
                        deposit.setDepositor(depositInfoList.get(j).getValue());
                    }

                    else if(depositInfoList.get(j).getName().equals("accountId")) {
                        deposit.setAccountId(depositInfoList.get(j).getValue());
                    }

                    else if(depositInfoList.get(j).getName().equals("amountOnDeposit")) {
                        deposit.setAmountOnDeposit(depositInfoList.get(j).getValue());
                    }

                    else if(depositInfoList.get(j).getName().equals("profitability")) {
                        deposit.setProfitability(depositInfoList.get(j).getValue());
                    }

                    else if(depositInfoList.get(j).getName().equals("timeConstraints")) {
                        deposit.setTimeConstraints(depositInfoList.get(j).getValue());
                    }
                }
                depositsList.add(deposit);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return depositsList;
    }
}
