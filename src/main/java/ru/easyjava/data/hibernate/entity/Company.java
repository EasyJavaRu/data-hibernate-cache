package ru.easyjava.data.hibernate.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.stream.Collectors;

@SuppressWarnings("PMD")
@Entity
@Cacheable
public class Company extends AbstractIdentifiableObject {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "workingPlaces")
    private Collection<Person> workers;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", workers=" + workers
                .stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(","))
                + '}';
    }
}
