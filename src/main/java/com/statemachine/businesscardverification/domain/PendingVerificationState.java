package com.statemachine.businesscardverification.domain;

import com.statemachine.businesscardverification.constants.CardState;

public class PendingVerificationState extends State {

    @Override
    public String getStateName() {
        return CardState.PENDING_VERIFICATION.getValue();
    }

    @Override
    public State strongVerification(State state) {
        System.out.println("The action 'Strong Verification' is allowed in state " + state.getStateName());
        return new StrongApprovedState();
    }

    @Override
    public State abort(State state) {
        System.out.println("The action 'Abort' is allowed in state " + state.getStateName());
        return new UnknownState();
    }

}
