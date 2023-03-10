package edu.escuelaing.persistence;

import java.util.List;

import edu.escuelaing.model.Usuario;

public interface UsuarioPersistence {

    public List<Usuario> findAll();

    public boolean existsById(int id);

    public void save(Usuario usuario);

    public Usuario findById(int id);

    public void update(int id, Usuario usuario);

    public void delete(int id);

}
