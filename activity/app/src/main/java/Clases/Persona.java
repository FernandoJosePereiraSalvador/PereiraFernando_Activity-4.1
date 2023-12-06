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
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nif", unique = true, nullable = false, length = 9)
    private String nif;
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;
    @Column(name = "apellido2", length = 50)
    private String apellido2;
    @Column(name = "ciudad", nullable = false, length = 25)
    private String ciudad;
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Column(name = "telefono", length = 9)
    private String telefono;
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "sexo", nullable = false, length = 1)
    private char sexo;
    public Persona(String nif, String nombre, String apellido1, String apellido2, String ciudad, String direccion, String telefono, Date fechaNacimiento, char sexo) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }
    
    public Persona(){
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", ciudad=" + ciudad + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + '}';
    }
    
}