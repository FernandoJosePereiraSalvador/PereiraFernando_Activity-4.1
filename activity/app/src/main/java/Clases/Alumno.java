/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.persistence.*;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "alumno")
@PrimaryKeyJoinColumn(name = "id_alumno")
public class Alumno extends Persona {

    @Column(name = "nie", nullable = false)
    private int nie;

    @ManyToOne
    @JoinColumn(name = "id_grado", nullable = false)
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "grupo_alumno")
    private GrupoEstudiantes grupoAlumno;

    public int getNie() {
        return nie;
    }

    public void setNie(int nie) {
        this.nie = nie;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public GrupoEstudiantes getGrupoAlumno() {
        return grupoAlumno;
    }

    public void setGrupoAlumno(GrupoEstudiantes grupoAlumno) {
        this.grupoAlumno = grupoAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nie=" + nie + ", grado=" + grado + ", grupoAlumno=" + grupoAlumno + '}';
    }
    
    
}