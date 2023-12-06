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
@Table(name = "grupo_asignaturas")
@PrimaryKeyJoinColumn(name = "id_curso_escolar")
public class GrupoAsignaturas extends Grupo {

    @Column(name = "plan_enseñanza", length = 50)
    private String planEnsenanza;

    @Column(name = "recursos_compartidos", length = 50)
    private String recursosCompartidos;

    public GrupoAsignaturas() {
        // Constructor por defecto necesario para JPA
    }

    public GrupoAsignaturas(String nombre, CursoEscolar cursoEscolar, String planEnsenanza, String recursosCompartidos) {
        super(nombre, cursoEscolar);
        this.planEnsenanza = planEnsenanza;
        this.recursosCompartidos = recursosCompartidos;
    }

    public String getPlanEnsenanza() {
        return planEnsenanza;
    }

    public void setPlanEnsenanza(String planEnsenanza) {
        this.planEnsenanza = planEnsenanza;
    }

    public String getRecursosCompartidos() {
        return recursosCompartidos;
    }

    public void setRecursosCompartidos(String recursosCompartidos) {
        this.recursosCompartidos = recursosCompartidos;
    }

    @Override
    public String toString() {
        return "GrupoAsignaturas{" + "planEnsenanza=" + planEnsenanza + ", recursosCompartidos=" + recursosCompartidos + '}';
    }

    
}