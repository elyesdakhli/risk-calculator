package org.dakhli.elyes;

import org.dakhli.elyes.model.Contract;
import org.dakhli.elyes.model.CounterParty;
import org.dakhli.elyes.model.RiskNode;
import org.dakhli.elyes.model.Transaction;

import java.util.List;

public class RiskCalculator {
    public static int calculate(RiskNode riskNode){
        checkCalculateInput(riskNode);

        int leafsRisk = riskNode.sumRiskValues();
        List<RiskNode> riskNodes = riskNode.getChildrenNodes();

        if(riskNodes == null || riskNodes.isEmpty()){
            return leafsRisk;
        }
        int childrenNodesSum = 0;
        for(RiskNode rn : riskNodes){
            childrenNodesSum += calculate(rn);
        }
        return leafsRisk + childrenNodesSum;
    }

    private static void checkCalculateInput(RiskNode riskNode) {
        if(riskNode == null){
            throw new IllegalArgumentException("riskNode cannot be null");
        }
    }
}
