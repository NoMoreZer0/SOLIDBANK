package com.example.solidbankingapp.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountTypeRequest {
    private String type;

    @JsonCreator
    public AccountTypeRequest(@JsonProperty("type") String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccountTypeRequest{" +
                "type='" + type + '\'' +
                '}';
    }
}
