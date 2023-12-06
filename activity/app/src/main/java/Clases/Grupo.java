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
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_curso_escolar", nullable = false)
    private CursoEscolar cursoEscolar;

    public Grupo() {
    }

    public Grupo(String nombre, CursoEscolar cursoEscolar) {
        this.nombre = nombre;
        this.cursoEscolar = cursoEscolar;
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

    public CursoEscolar getCursoEscolar() {
        return cursoEscolar;
    }

    public void setCursoEscolar(CursoEscolar cursoEscolar) {
        this.cursoEscolar = cursoEscolar;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", nombre=" + nombre + ", cursoEscolar=" + cursoEscolar + '}';
    }

    
}
