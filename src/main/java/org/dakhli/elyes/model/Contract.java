package org.dakhli.elyes.model;

import java.util.ArrayList;
import java.util.List;

public class Contract implements RiskNode{
    private final List<RiskNode> relatedContracts = new ArrayList<>();
    private final List<RiskLeaf> transactions = new ArrayList<>();

    public List<RiskNode> getChildrenNodes() {
        return relatedContracts;
    }

    @Override
    public List<RiskLeaf> getChildrenLeafs() {
        return transactions;
    }

    public Contract withTransactions(Transaction... transactions) {
        if(transactions == null || transactions.length == 0){
            return this;
        }

        addLeaves(transactions);
        return this;
    }

    public Contract withRelatedContracts(Contract... contracts) {
        if(contracts == null || contracts.length == 0){
            return this;
        }

        addNodes(contracts);
        return this;
    }
}
