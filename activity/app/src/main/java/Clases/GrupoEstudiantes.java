/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "grupo_estudiantes")
@PrimaryKeyJoinColumn(name = "id_curso_escolar")
public class GrupoEstudiantes extends Grupo {

    @Column(name = "nombre_hermandad", length = 50)
    private String nombreHermandad;

    @Column(name = "sede", length = 50)
    private String sede;

    public GrupoEstudiantes() {
    }

    public GrupoEstudiantes(String nombre, CursoEscolar cursoEscolar, String nombreHermandad, String sede) {
        super(nombre, cursoEscolar);
        this.nombreHermandad = nombreHermandad;
        this.sede = sede;
    }

    public String getNombreHermandad() {
        return nombreHermandad;
    }

    public void setNombreHermandad(String nombreHermandad) {
        this.nombreHermandad = nombreHermandad;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "GrupoEstudiantes{" + "nombreHermandad=" + nombreHermandad + ", sede=" + sede + '}';
    }
    
    
    
}
