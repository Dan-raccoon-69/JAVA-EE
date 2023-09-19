/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Usuario;

/**
 *
 * @author Daniel
 */
public class ControladoraPersistencia {
    HorarioJpaController horaJPA = new HorarioJpaController();
    OdontologoJpaController odontoJpa = new OdontologoJpaController();
    PacienteJpaController pacienteJPA =  new PacienteJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    ResponsableJpaController responsableJPA = new ResponsableJpaController();
    SecretarioJpaController secreJPA = new SecretarioJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();

    public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);
    }
    
    
            
    
}
