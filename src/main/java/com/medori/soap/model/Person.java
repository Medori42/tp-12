package com.medori.soap.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a person entity in the system.
 * <p>
 * This class is annotated with JAXB annotations for XML binding.
 * </p>
 * 
 * @author Medori42
 */
@XmlRootElement(name = "Person")
public class Person {

    private String id;
    private String name;
    private int age;

    /**
     * Default constructor required by JAXB.
     */
    public Person() {
    }

    /**
     * Constructs a new Person with the specified details.
     * 
     * @param id   The unique identifier for the person.
     * @param name The name of the person.
     * @param age  The age of the person.
     */
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters

    /**
     * Gets the person's ID.
     * 
     * @return The ID.
     */
    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the person's name.
     * 
     * @return The name.
     */
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the person's age.
     * 
     * @return The age.
     */
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
