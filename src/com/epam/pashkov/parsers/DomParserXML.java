package com.epam.pashkov.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.epam.pashkov.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 06.05.2015.
 */
public class DomParserXML {
    public static ArrayList<Bank.Deposit> parse(){
        ArrayList<Bank.Deposit> depositsList = new ArrayList<Bank.Deposit>();
        Bank bank = new Bank();
        try
        {
            File xmlFile = new File("deposits.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());


            for(int tmp = 0; tmp < nodeList.getLength(); tmp++)
            {
                Node node = nodeList.item(tmp);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    String name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                    String country = element.getElementsByTagName("country").item(0).getChildNodes().item(0).getNodeValue();
                    String type = element.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue();
                    String depositor = element.getElementsByTagName("depositor").item(0).getChildNodes().item(0).getNodeValue();
                    String accountId = element.getElementsByTagName("accountId").item(0).getChildNodes().item(0).getNodeValue();
                    String amountOnDeposit = element.getElementsByTagName("amountOnDeposit").item(0).getChildNodes().item(0).getNodeValue();
                    String profitability = element.getElementsByTagName("profitability").item(0).getChildNodes().item(0).getNodeValue();
                    String timeConstraints = element.getElementsByTagName("timeConstraints").item(0).getChildNodes().item(0).getNodeValue();
                    depositsList.add(bank.new Deposit(name,country,type,depositor,accountId,amountOnDeposit,profitability,timeConstraints));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return depositsList;
    }
}
