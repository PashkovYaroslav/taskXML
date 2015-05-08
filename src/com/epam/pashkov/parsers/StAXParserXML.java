package com.epam.pashkov.parsers;

import com.epam.pashkov.Bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXParserXML {
    public static ArrayList<Bank.Deposit> parse() {
        ArrayList<Bank.Deposit> depositsList = null;
        Bank bank = new Bank();
        Bank.Deposit currentDeposit = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            InputStream inputStream = new FileInputStream(new File("deposits.xml"));
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("deposit".equals(reader.getLocalName())) {
                            currentDeposit = bank.new Deposit();
                        }
                        if ("bank".equals(reader.getLocalName())) {
                            depositsList = new ArrayList<Bank.Deposit>();
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "deposit":
                                depositsList.add(currentDeposit);
                                break;
                            case "name":
                                currentDeposit.setName(tagContent);
                                break;
                            case "country":
                                currentDeposit.setCountry(tagContent);
                                break;
                            case "type":
                                currentDeposit.setType(tagContent);
                                break;
                            case "depositor":
                                currentDeposit.setDepositor(tagContent);
                                break;
                            case "accountId":
                                currentDeposit.setAccountId(tagContent);
                                break;
                            case "amountOnDeposit":
                                currentDeposit.setAmountOnDeposit(tagContent);
                                break;
                            case "profitability":
                                currentDeposit.setProfitability(tagContent);
                                break;
                            case "timeConstraints":
                                currentDeposit.setTimeConstraints(tagContent);
                                break;
                        }
                        break;

                    case XMLStreamConstants.START_DOCUMENT:
                        depositsList = new ArrayList<Bank.Deposit>();
                        break;
                }

            }
        }
        catch(XMLStreamException |IOException ex){
            ex.getMessage();
        }
        return depositsList;
    }
}