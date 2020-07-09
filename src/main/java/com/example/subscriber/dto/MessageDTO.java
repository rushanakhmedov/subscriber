package com.example.subscriber.dto;

import com.example.subscriber.helper.ActionType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MessageDTO {

    @NotNull
    private long msisdn;

    @NotBlank
    @Pattern(regexp = ActionType.pattern)
    private String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
