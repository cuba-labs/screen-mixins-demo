package com.company.demo.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|title")
@Table(name = "DEMO_PRODUCT")
@Entity(name = "demo_Product")
public class Product extends StandardEntity {
    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @Lob
    @NotNull
    @Column(name = "SUMMARY", nullable = false)
    protected String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}