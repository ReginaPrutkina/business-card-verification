package com.statemachine.businesscardverification.domain;

public interface Actions {
    default State contactAddress(State state) {
        System.out.println("The action 'Contact Address' is not allowed in state " + state.getStateName());
        return state;
    }

    default State strongVerification(State state) {
        System.out.println("The action 'Strong Verification' is not allowed in state " + state.getStateName());
        return state;
    }

    default State manualVerification(State state) {
        System.out.println("The action 'Manual Verification' is not allowed in state " + state.getStateName());
        return state;
    }

    default State abort(State state) {
        System.out.println("The action 'Abort' is not allowed in state " + state.getStateName());
        return state;
    }

    default State unVerify(State state) {
        System.out.println("The action 'Un Verify' is not allowed in state " + state.getStateName());
        return state;
    }
}
