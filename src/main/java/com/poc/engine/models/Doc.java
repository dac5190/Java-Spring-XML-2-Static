package com.poc.engine.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class Doc {

    @XmlElement(name = "id")
    private String id; // The slug for the URL (e.g., "getting-started")

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "category")
    private String category;

    @XmlElement(name = "summary_text")
    private String summary;

    @XmlElementWrapper(name = "content_steps")
    @XmlElement(name = "item")
    private String[] items;

    // Default constructor for JAXB
    public Doc() {}

    // Manual getters to ensure Thymeleaf/Eclipse can see them if Lombok is finicky
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getSummary() {
        return summary;
    }

    public String[] getItems() {
        return items;
    }
}