package com.relations.ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="persona_id")
    private Long id;
    private String nombre;
    private int edad;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Habilidad> habilidades = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    //Sirve para no serializar a json esta propiedad
    //@JsonBackReference
    @JsonIgnoreProperties("listapersonas")
    @JoinTable(name = "personas_fiestas",
            joinColumns = @JoinColumn(name="persona_id", referencedColumnName = "persona_id"),
            inverseJoinColumns = @JoinColumn(name="fiesta_id", referencedColumnName = "fiesta_id"))
    private Set<Fiesta> listafiestas = new HashSet<>();

    //getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public Set<Fiesta> getListafiestas() {
        return listafiestas;
    }

    public void setListafiestas(Set<Fiesta> listafiestas) {
        this.listafiestas = listafiestas;
    }

    public Persona(){
        super();
    }
}
