/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Modelo;

import Clases.Persona;
import java.util.Date;
import javax.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        ConexionOBD conexionOBD = new ConexionOBD("miUnidadPersistencia");
        
        try {
            EntityManager entityManager = conexionOBD.getEM();
            
            Persona persona_prueba = new Persona(
                "123456795",             
                "Juan",                
                "Pérez",               
                "Gómez",          
                "Ciudad Ejemplo",       
                "Calle Principal 123",  
                "987654321",          
                new Date(),               
                'M'                 
            );
            
            entityManager.getTransaction().begin();
            
            entityManager.persist(persona_prueba);
            
            entityManager.getTransaction().commit();
            
            entityManager.close();
            
            
            
                    
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
