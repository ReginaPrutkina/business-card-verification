package com.statemachine.businesscardverification.domain;

import com.statemachine.businesscardverification.constants.CardState;

public class KnownState extends State {

    @Override
    public String getStateName() {
        return CardState.KNOWN.getValue();
    }

    @Override
    public State contactAddress(State state) {
        System.out.println("The action 'Contact Address' is allowed in state " + state.getStateName());
        return new AdditionalVerificationState();
    }

    @Override
    public State manualVerification(State state) {
        System.out.println("The action 'Manual Verification' is allowed in state " + state.getStateName());
        return new ManualApprovedState();
    }

}
