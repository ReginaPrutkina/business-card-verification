package com.statemachine.businesscardverification.domain;

public abstract class State implements Actions {
    abstract String getStateName();
}
