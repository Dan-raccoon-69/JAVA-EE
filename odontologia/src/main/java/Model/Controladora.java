/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Persistencia.ControladoraPersistencia;

/**
 *
 * @author Daniel
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario(int id, String nombreUsuario, String contrasenia, String rol){
        Usuario usu = new Usuario(id, nombreUsuario, contrasenia, rol);
        controlPersis.crearUsuario(usu);
    }
}
