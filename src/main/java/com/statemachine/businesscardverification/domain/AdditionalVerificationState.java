package com.statemachine.businesscardverification.domain;

import com.statemachine.businesscardverification.constants.CardState;

public class AdditionalVerificationState extends State {

    @Override
    public String getStateName() {
        return CardState.ADDITIONAL_VERIFICATION.getValue();
    }

    @Override
    public State abort(State state) {
        System.out.println("The action 'Abort' is allowed in state " + state.getStateName());
        return new KnownState();
    }

    @Override
    public State strongVerification(State state) {
        System.out.println("The action 'Strong Verification' is allowed in state " + state.getStateName());
        return new StrongApprovedState();
    }
}
