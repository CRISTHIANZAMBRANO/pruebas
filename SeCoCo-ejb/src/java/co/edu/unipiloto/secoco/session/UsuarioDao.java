/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.secoco.session;

import javax.ejb.Stateless;

import co.edu.unipiloto.secoco.entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author crist
 */
@Stateless
public class UsuarioDao implements UsuarioDaoLocal {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void addUsuario(Usuarios usuario) {
        em.persist(usuario);
    }

    @Override
    public void editUsuario(Usuarios usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(int cedula) {
        em.remove(getUsuario(cedula));
    }

    @Override
    public Usuarios getUsuario(int cedula) {
        return em.find(Usuarios.class, cedula);
    }

    @Override
    public List<Usuarios> getAllUsuarios() {
        return em.createNamedQuery("Usuario.getAll").getResultList();
    }
    
}