package com.restaurante.dsi.model.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restaurante.dsi.model.auth.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter
public class UserNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"UserNotification"})
    private User users;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;
    private Long status;
}
