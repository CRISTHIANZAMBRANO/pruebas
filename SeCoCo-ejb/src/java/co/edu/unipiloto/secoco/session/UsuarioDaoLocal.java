/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.secoco.session;

import co.edu.unipiloto.secoco.entity.Usuarios;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author crist
 */
@Local
public interface UsuarioDaoLocal {

    void addUsuario(Usuarios usuario);

    void editUsuario(Usuarios usuario);

    void deleteUsuario(int cedula);

    Usuarios getUsuario(int cedula);

    List<Usuarios> getAllUsuarios();
    
}