package com.example.subscriber.dto;

import com.example.subscriber.helper.ActionType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MessageDTO {

    @NotNull
    private long msisdn;

    @NotNull
    private ActionType action;

    @NotNull
    @Min(0)
    private long timestamp;

    public MessageDTO() {
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
