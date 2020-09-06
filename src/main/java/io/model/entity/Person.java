package io.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
  @NamedQuery(
    name = "Person.findAll",
    query = "select p from Person p"
  ),
  @NamedQuery(
    name = "Person.findByName",
    query = "select p from Person p where p.name = :name"
  )
})
public class Person implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "person_id")
  private int id;

  @Column(name = "person_name")
  private String name;

  public Person() {}

  public Person(final int id, final String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
