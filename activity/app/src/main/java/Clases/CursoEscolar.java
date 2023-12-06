/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "curso_escolar")
public class CursoEscolar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "anyo_inicio", nullable = false)
    private int anyoInicio;

    @Column(name = "anyo_fin", nullable = false)
    private int anyoFin;

    public CursoEscolar() {
    }

    public CursoEscolar(int anyoInicio, int anyoFin) {
        this.anyoInicio = anyoInicio;
        this.anyoFin = anyoFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnyoInicio() {
        return anyoInicio;
    }

    public void setAnyoInicio(int anyoInicio) {
        this.anyoInicio = anyoInicio;
    }

    public int getAnyoFin() {
        return anyoFin;
    }

    public void setAnyoFin(int anyoFin) {
        this.anyoFin = anyoFin;
    }

    @Override
    public String toString() {
        return "CursoEscolar{" + "id=" + id + ", anyoInicio=" + anyoInicio + ", anyoFin=" + anyoFin + '}';
    }
    
    
}
