package com.statemachine.businesscardverification.domain;

import com.statemachine.businesscardverification.constants.CardState;
import lombok.Getter;

@Getter
public class ManualApprovedState extends State {

    @Override
    public String getStateName() {
        return CardState.MANUAL_APPROVED.getValue();
    }

    @Override
    public State unVerify(State state) {
        System.out.println("The action 'Un Verify' is allowed in state " + state.getStateName());
        return new KnownState();
    }
}
