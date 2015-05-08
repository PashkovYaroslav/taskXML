package com.epam.pashkov;

/**
 * Created by Yaroslav on 06.05.2015.
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Deposit> deposits;

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public class Deposit{
        private String name;
        private String country;
        private String type;
        private String depositor;
        private String accountId;
        private String amountOnDeposit;
        private String profitability;
        private String timeConstraints;

        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }


        public void setCountry(String country) {
            this.country = country;
        }

        public String getType() {
            return type;
        }


        public void setType(String type) {
            this.type = type;
        }

        public String getDepositor() {
            return depositor;
        }


        public void setDepositor(String depositor) {
            this.depositor = depositor;
        }

        public String getAccountId() {
            return accountId;
        }


        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getAmountOnDeposit() {
            return amountOnDeposit;
        }


        public void setAmountOnDeposit(String amountOnDeposit) {
            this.amountOnDeposit = amountOnDeposit;
        }

        public String getProfitability() {
            return profitability;
        }


        public void setProfitability(String profitability) {
            this.profitability = profitability;
        }

        public String getTimeConstraints() {
            return timeConstraints;
        }


        public void setTimeConstraints(String timeConstraints) {
            this.timeConstraints = timeConstraints;
        }

        public Deposit(String name, String country, String type, String depositor, String accountId, String amountOnDeposit, String profitability, String timeConstraints) {
            this.setName(name);
            this.setCountry(country);
            this.setType(type);
            this.setDepositor(depositor);
            this.setAccountId(accountId);
            this.setAmountOnDeposit(amountOnDeposit);
            this.setProfitability(profitability);
            this.setTimeConstraints(timeConstraints);
        }

        public Deposit(){

        }

        @Override
        public String toString() {
            return "Deposit{" +
                    "name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", type='" + type + '\'' +
                    ", depositor='" + depositor + '\'' +
                    ", accountId='" + accountId + '\'' +
                    ", amountOnDeposit='" + amountOnDeposit + '\'' +
                    ", profitability='" + profitability + '\'' +
                    ", timeConstraints='" + timeConstraints + '\'' +
                    '}';
        }
    }
}
