package com.statemachine.businesscardverification.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BusinessCardTest {

    private BusinessCard businessCard;

    @BeforeEach
    void setUp() {
        businessCard = BusinessCard.builder()
                .cardId(1L)
                .name("some name")
                .address("some address")
                .build();
    }

    @Nested
    @DisplayName("positive scenarios with allowed actions")
    class AllowedScenarioTest {

        @Test
        @DisplayName("UnknownState => PendingVerificationState => StrongApprovedState")
        void UnknownToPendingVerificationToStrongApprovedTest() {

            businessCard.setState(new UnknownState());
            businessCard.printState();

            businessCard.contactAddress();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof PendingVerificationState);

            businessCard.strongVerification();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof StrongApprovedState);
        }

        @Test
        @DisplayName("PendingVerificationState => UnknownState")
        void PendingVerificationToUnknownTest() {
            businessCard.setState(new PendingVerificationState());
            businessCard.printState();

            businessCard.abort();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof UnknownState);
        }

        @Test
        @DisplayName("KnownState => AdditionalVerificationState => StrongApprovedState")
        void KnownToAdditionalVerificationToStrongApproved() {
            businessCard.setState(new KnownState());
            businessCard.printState();

            businessCard.contactAddress();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof AdditionalVerificationState);

            businessCard.strongVerification();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof StrongApprovedState);
        }

        @Test
        @DisplayName("AdditionalVerificationState => KnownState")
        void AdditionalVerificationToKnownToAdditionalVerification() {
            businessCard.setState(new AdditionalVerificationState());
            businessCard.printState();

            businessCard.abort();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof KnownState);
        }

        @Test
        @DisplayName("KnownState => ManualApprovedState")
        void KnownManualToApproved() {
            businessCard.setState(new KnownState());
            businessCard.printState();

            businessCard.manualVerification();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof ManualApprovedState);
        }

        @Test
        @DisplayName("ManualApprovedState => KnownState ")
        void ApprovedToKnownManual() {
            businessCard.setState(new ManualApprovedState());
            businessCard.printState();

            businessCard.unVerify();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof KnownState);
        }
    }

    @Nested
    @DisplayName("Invalid actions")
    class InvalidActions {
        @Test
        @DisplayName("invalid actions for UnknownState ")
        void ActionsThatDoesNotChangeUnknownState() {
            businessCard.setState(new UnknownState());
            businessCard.printState();

            businessCard.strongVerification();
            businessCard.printState();
            businessCard.manualVerification();
            businessCard.printState();
            businessCard.abort();
            businessCard.printState();
            businessCard.unVerify();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof UnknownState);
        }

        @Test
        @DisplayName("invalid actions for PendingVerificationState ")
        void ActionsThatDoesNotChangePendingVerificationState() {
            businessCard.setState(new PendingVerificationState());
            businessCard.printState();

            businessCard.contactAddress();
            businessCard.printState();
            businessCard.manualVerification();
            businessCard.printState();
            businessCard.unVerify();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof PendingVerificationState);
        }

        @Test
        @DisplayName("invalid actions for StrongApprovedState ")
        void ActionsThatDoesNotChangeStrongApprovedState() {
            businessCard.setState(new StrongApprovedState());
            businessCard.printState();

            businessCard.contactAddress();
            businessCard.printState();
            businessCard.manualVerification();
            businessCard.printState();
            businessCard.abort();
            businessCard.printState();
            businessCard.unVerify();
            businessCard.printState();
            businessCard.strongVerification();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof StrongApprovedState);
        }

        @Test
        @DisplayName("invalid actions for KnownState ")
        void ActionsThatDoesNotChangeKnownState() {
            businessCard.setState(new KnownState());
            businessCard.printState();

            businessCard.abort();
            businessCard.printState();
            businessCard.unVerify();
            businessCard.printState();
            businessCard.strongVerification();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof KnownState);
        }

        @Test
        @DisplayName("invalid actions for AdditionalVerificationState ")
        void ActionsThatDoesNotChangeAdditionalVerificationState() {
            businessCard.setState(new AdditionalVerificationState());
            businessCard.printState();

            businessCard.contactAddress();
            businessCard.printState();
            businessCard.manualVerification();
            businessCard.printState();
            businessCard.unVerify();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof AdditionalVerificationState);
        }

        @Test
        @DisplayName("invalid actions for ManualApprovedState ")
        void ActionsThatDoesNotChangeManualApprovedState() {
            businessCard.setState(new ManualApprovedState());
            businessCard.printState();

            businessCard.contactAddress();
            businessCard.printState();
            businessCard.manualVerification();
            businessCard.printState();
            businessCard.abort();
            businessCard.printState();
            businessCard.strongVerification();
            businessCard.printState();
            assertTrue(businessCard.getState() instanceof ManualApprovedState);
        }
    }
}