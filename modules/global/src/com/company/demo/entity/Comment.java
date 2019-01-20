package com.company.demo.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table(name = "DEMO_COMMENT")
@Entity(name = "demo_Comment")
public class Comment extends StandardEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @NotNull
    @Column(name = "CONVERSATION", nullable = false)
    protected UUID conversation;

    @NotNull
    @Column(name = "TEXT", nullable = false, length = 2000)
    protected String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getConversation() {
        return conversation;
    }

    public void setConversation(UUID conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}