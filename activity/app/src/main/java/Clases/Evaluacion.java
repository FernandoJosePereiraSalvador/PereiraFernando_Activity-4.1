/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.persistence.*;
import java.util.Date;
/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "evaluacion")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "id_grupo_estudiantes", nullable = false)
    private GrupoEstudiantes grupoEstudiantes;

    public Evaluacion() {
        // Constructor por defecto necesario para JPA
    }

    public Evaluacion(String nombre, Date fecha, Asignatura asignatura, GrupoEstudiantes grupoEstudiantes) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.asignatura = asignatura;
        this.grupoEstudiantes = grupoEstudiantes;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", asignatura=" + asignatura + ", grupoEstudiantes=" + grupoEstudiantes + '}';
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public GrupoEstudiantes getGrupoEstudiantes() {
        return grupoEstudiantes;
    }

    public void setGrupoEstudiantes(GrupoEstudiantes grupoEstudiantes) {
        this.grupoEstudiantes = grupoEstudiantes;
    }

    
}
