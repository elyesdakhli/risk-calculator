package org.dakhli.elyes.model;

public class Transaction implements RiskLeaf{
    private int riskValue;

    public Transaction(int riskValue){
        this.riskValue = riskValue;
    }

    public int getRiskValue() {
        return riskValue;
    }
}
