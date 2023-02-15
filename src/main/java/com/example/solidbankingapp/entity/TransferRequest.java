package com.example.solidbankingapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferRequest {
    private String destAccountID;

    public String getDestAccountID() {
        return destAccountID;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "destAccountID='" + destAccountID + '\'' +
                '}';
    }

    public void setDestAccountID(String destAccountID) {
        this.destAccountID = destAccountID;
    }

    public TransferRequest(@JsonProperty("destination_account_id") String destAccountID) {
        this.destAccountID = destAccountID;
    }
}
