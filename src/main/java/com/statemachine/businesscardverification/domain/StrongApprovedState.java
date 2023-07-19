package com.statemachine.businesscardverification.domain;

import com.statemachine.businesscardverification.constants.CardState;
import lombok.Getter;

@Getter
public class StrongApprovedState extends State {

    @Override
    public String getStateName() {
        return CardState.STRONG_APPROVED.getValue();
    }
}
