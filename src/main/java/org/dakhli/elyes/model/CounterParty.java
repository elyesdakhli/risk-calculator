package org.dakhli.elyes.model;

import java.util.ArrayList;
import java.util.List;

public class CounterParty implements RiskNode{
    private final List<RiskNode> contracts = new ArrayList<>();
    private final List<RiskLeaf> transactions = new ArrayList<>();

    public List<RiskNode> getChildrenNodes() {
        return contracts;
    }

    @Override
    public List<RiskLeaf> getChildrenLeafs() {
        return transactions;
    }

    public CounterParty withTransactions(Transaction... transactions) {
        if(transactions == null || transactions.length == 0){
            return this;
        }

        addLeaves(transactions);
        return this;
    }

    public CounterParty withContracts(Contract... contracts) {
        if(contracts == null || contracts.length == 0){
            return this;
        }

        addNodes(contracts);
        return this;
    }


}
