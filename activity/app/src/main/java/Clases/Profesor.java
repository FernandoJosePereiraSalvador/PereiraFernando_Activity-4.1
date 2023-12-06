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
@DiscriminatorValue("PROFESOR")
public class Profesor extends Persona {

    @Column(name = "id_departamento", nullable = false)
    private int idDepartamento;

    public Profesor() {
    }

    public Profesor(String nif, String nombre, String apellido1, String apellido2, String ciudad, String direccion,
                    String telefono, java.sql.Date fechaNacimiento, char sexo, int idDepartamento) {
        super(nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fechaNacimiento, sexo);
        this.idDepartamento = idDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idDepartamento=" + idDepartamento + '}';
    }
    
    
}
