package com.statemachine.businesscardverification.domain;

import com.statemachine.businesscardverification.constants.CardState;

public class UnknownState extends State {

    @Override
    public String getStateName() {
        return CardState.UNKNOWN.getValue();
    }

    @Override
    public State contactAddress(State state) {
        System.out.println("The action 'Contact Address' is allowed in state " + state.getStateName());
        return new PendingVerificationState();
    }
}
