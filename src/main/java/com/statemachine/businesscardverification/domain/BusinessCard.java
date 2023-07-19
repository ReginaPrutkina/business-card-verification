package com.statemachine.businesscardverification.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BusinessCard{
    private long cardId;
    private String name;
    private String address;
    private State state;

    public void printState() {
        System.out.println("Current state is " + state.getStateName());
    }

    public void contactAddress() {
        state = state.contactAddress(this.state);
    }

    public void strongVerification() {
        state = state.strongVerification(this.state);
    }

    public void manualVerification() {
        state = state.manualVerification(this.state);
    }

    public void abort() {
        state = state.abort(this.state);
    }

    public void unVerify() {
        state = state.unVerify(this.state);
    }
}

