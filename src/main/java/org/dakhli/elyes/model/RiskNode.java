package org.dakhli.elyes.model;

import java.util.Collections;
import java.util.List;

public interface RiskNode {

    List<RiskNode> getChildrenNodes();
    List<RiskLeaf> getChildrenLeafs();

    default int sumRiskValues(){
        return getChildrenLeafs().stream()
                .map(RiskLeaf::getRiskValue)
                .reduce(0, Integer::sum);
    }

    default void addNodes(RiskNode... newNodes){
        addToList(getChildrenNodes(), newNodes);
    }

    default void addLeaves(RiskLeaf... newLeafs){
        addToList(getChildrenLeafs(), newLeafs);
    }

    default <T> void addToList(List<T> dest, T[] src) {
        Collections.addAll(dest, src);
    }



}
