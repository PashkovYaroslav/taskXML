package com.epam.pashkov.parsers;

/**
 * Created by Yaroslav_Pashkov on 5/6/2015.
 */

import com.epam.pashkov.Bank;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;


public class SaxParserXML {
    public static ArrayList<Bank.Deposit> parse() {
        ArrayList<Bank.Deposit> depositsList = new ArrayList<Bank.Deposit>();
        Bank bank = new Bank();

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            DefaultHandler defaultHandler = new DefaultHandler() {
                boolean name = false;
                boolean country = false;
                boolean type = false;
                boolean depositor = false;
                boolean accountId = false;
                boolean amountOnDeposit = false;
                boolean profitability = false;
                boolean timeConstraints = false;
                String nameStr = "",countryStr="",typeStr="",depositorStr="",accountIdStr="",amountOnDepositStr="",profitabilityStr="",timeConstraintsStr = "";

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("NAME")) {
                        name = true;
                    }
                    if (qName.equalsIgnoreCase("COUNTRY")) {
                        country = true;
                    }
                    if (qName.equalsIgnoreCase("TYPE")) {
                        type = true;
                    }
                    if (qName.equalsIgnoreCase("DEPOSITOR")) {
                        depositor = true;
                    }
                    if (qName.equalsIgnoreCase("ACCOUNTID")) {
                        accountId = true;
                    }
                    if (qName.equalsIgnoreCase("AMOUNTONDEPOSIT")) {
                        amountOnDeposit = true;
                    }
                    if (qName.equalsIgnoreCase("PROFITABILITY")) {
                        profitability = true;
                    }
                    if (qName.equalsIgnoreCase("TIMECONSTRAINTS")) {
                        timeConstraints = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if(qName.equals("deposit")){
                        depositsList.add(bank.new Deposit(nameStr,countryStr,typeStr,depositorStr,accountIdStr,amountOnDepositStr,profitabilityStr,timeConstraintsStr));
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (name) {
                        nameStr = new String(ch, start, length);
                        name = false;
                    }
                    if (country) {
                        countryStr = new String(ch, start, length);
                        country = false;
                    }
                    if (type) {
                        typeStr = new String(ch, start, length);
                        type = false;
                    }
                    if (depositor) {
                        depositorStr = new String(ch, start, length);
                        depositor = false;
                    }
                    if (accountId) {
                        accountIdStr = new String(ch, start, length);
                        accountId = false;
                    }
                    if (amountOnDeposit) {
                        amountOnDepositStr = new String(ch, start, length);
                        amountOnDeposit = false;
                    }
                    if (profitability) {
                        profitabilityStr = new String(ch, start, length);
                        profitability = false;
                    }
                    if (timeConstraints) {
                        timeConstraintsStr = new String(ch, start, length);
                        timeConstraints = false;
                    }
                }
            };

            InputStream inputStream = new FileInputStream(new File("deposits.xml"));
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            InputSource inputSource = new InputSource(reader);
            inputSource.setEncoding("UTF-8");

            saxParser.parse(inputSource, defaultHandler);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }

        return depositsList;
    }
}

