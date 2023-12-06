/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Fernando
 */
public class ConexionOBD {

    private EntityManagerFactory emf;
    private EntityManager em;
    private String nombreBD;

    /**
     * Crea una objeto a la BBDD indicada
     */
    public ConexionOBD(String nombre) {
        this.emf = null;
        this.em = null;
        this.nombreBD = nombre;
    }

    /**
     * Método que realiza la conexión
     */
    private void conectar() {
        emf = Persistence.createEntityManagerFactory(nombreBD);
        try {
            em = emf.createEntityManager();
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Metodo que desconecta
     */
    public void desconectar() {
        this.em.close();
        this.emf.close();
        this.em = null;
        this.emf = null;
    }

    /**
     * @return El EntityManager sobre el que operar
     */
    public EntityManager getEM() {
        if (em == null)
            conectar();
        return em;
    }
}
