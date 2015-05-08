

package com.epam.pashkov.parsers;

import com.epam.pashkov.Bank;

import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;

import javax.xml.bind.annotation.*;

/**
 * Created by Yaroslav_Pashkov on 5/7/2015.
 */


public class JaxbParserXML {
    public static ArrayList<Bank.Deposit> parse() {
        ArrayList<Bank.Deposit> depositsList = new ArrayList<Bank.Deposit>();
        Bank bank = new Bank();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BankXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BankXML deposits = (BankXML) jaxbUnmarshaller.unmarshal(new File("deposits.xml"));

            for (DepositXML depositXML : deposits.depositXMLList) {

                depositsList.add(bank.new Deposit(depositXML.name,
                        depositXML.country,
                        depositXML.type,
                        depositXML.depositor,
                        depositXML.accountId,
                        depositXML.amountOnDeposit,
                        depositXML.profitability,
                        depositXML.timeConstraints));
            }

        } catch (JAXBException jaxbe) {
            System.out.println(jaxbe.getLocalizedMessage());
            jaxbe.printStackTrace();
        }

        return depositsList;
    }
}

@XmlRootElement(name = "bank")
@XmlAccessorType(XmlAccessType.FIELD)
class BankXML {
    //@XmlElementWrapper(name="bank")
    @XmlElement(name = "deposit")
    public ArrayList<DepositXML> depositXMLList;
}

@XmlAccessorType(XmlAccessType.FIELD)
class DepositXML {
    @XmlElement(name = "name")
    public String name;
    @XmlElement(name = "country")
    public String country;
    @XmlElement(name = "type")
    public String type;
    @XmlElement(name = "depositor")
    public String depositor;
    @XmlElement(name = "accountId")
    public String accountId;
    @XmlElement(name = "amountOnDeposit")
    public String amountOnDeposit;
    @XmlElement(name = "profitability")
    public String profitability;
    @XmlElement(name = "timeConstraints")
    public String timeConstraints;
}

