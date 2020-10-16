package com.banco.digital.repositories;

import com.banco.digital.entities.Usuario;
import com.banco.digital.resources.BaseRepository;

public interface UsuarioRepository extends BaseRepository<Usuario> {

	public Usuario findByEmail(String email);
}
