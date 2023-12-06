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
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "creditos", nullable = false)
    private float creditos;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "curso", nullable = false)
    private short curso;

    @Column(name = "cuatrimestre", nullable = false)
    private short cuatrimestre;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "id_grado", nullable = false)
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "grupo_asignaturas")
    private GrupoEstudiantes grupoAsignaturas;

    public Asignatura(String nombre, float creditos, String tipo, short curso, short cuatrimestre, Profesor profesor, Grado grado, GrupoEstudiantes grupoAsignaturas) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.tipo = tipo;
        this.curso = curso;
        this.cuatrimestre = cuatrimestre;
        this.profesor = profesor;
        this.grado = grado;
        this.grupoAsignaturas = grupoAsignaturas;
    }
    
    public Asignatura(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public short getCurso() {
        return curso;
    }

    public void setCurso(short curso) {
        this.curso = curso;
    }

    public short getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(short cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public GrupoEstudiantes getGrupoAsignaturas() {
        return grupoAsignaturas;
    }

    public void setGrupoAsignaturas(GrupoEstudiantes grupoAsignaturas) {
        this.grupoAsignaturas = grupoAsignaturas;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", tipo=" + tipo + ", curso=" + curso + ", cuatrimestre=" + cuatrimestre + ", profesor=" + profesor + ", grado=" + grado + ", grupoAsignaturas=" + grupoAsignaturas + '}';
    }
    
    
}