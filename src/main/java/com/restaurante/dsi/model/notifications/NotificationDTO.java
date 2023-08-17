package com.restaurante.dsi.model.notifications;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public interface   NotificationDTO {
    Long getId();
    String getMessage();
    @JsonProperty("create_at")
    Date getCreateAt();
    Long getStatus();
    @JsonProperty("user_id")
    Long getUserId();
}
