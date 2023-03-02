package edu.escuelaing.persistence.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.escuelaing.model.Usuario;
import edu.escuelaing.persistence.UsuarioPersistence;

@Component
public class UsuarioPersistenceImpl implements UsuarioPersistence {

    private final Map<Integer, Usuario> usuarios = new HashMap<>();

    public UsuarioPersistenceImpl() {

        List<String> nombres = List.of("David", "Santiago", "Pablo", "Silvana", "Jose", "Maria");
        List<String> apellidos = List.of("Martinez", "Silva", "Arango", "Castro", "Gamero", "Baquero");

        for (int i = 0; i < 6; i++) {
            Usuario usuario = new Usuario(i, nombres.get(i), apellidos.get(i),
                    apellidos.get(i).toLowerCase()  + "@hotmail.com", "escuelaing");
            usuarios.put(i, usuario);
        }
    }

    public boolean existsById(int id) {
        return usuarios.containsKey(id);
    }

    public List<Usuario> findAll() {
        return List.copyOf(usuarios.values());
    }

    public void save(Usuario usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            usuario.setId(usuarios.size());
        }
        usuarios.put(usuario.getId(), usuario);
    }

    public Usuario findById(int id) {
        return usuarios.get(id);
    }

    public void update(int id, Usuario usuario) {
        Usuario temp = findById(id);
        temp.setId(usuario.getId());
        temp.setNombre(usuario.getNombre());
        temp.setApellido(usuario.getApellido());
        temp.setEmail(usuario.getEmail());
        temp.setPassword(usuario.getPassword());

        usuarios.replace(usuario.getId(), temp);

    }

    public void delete(int id) {
        usuarios.remove(id);
    }

}
