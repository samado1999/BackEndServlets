package com.tiendavirtual.dao;

import java.util.ArrayList;

import com.tiendavirtual.dto.Usuario;

public interface UsuarioDAO {
	public Usuario crearUsuario(Usuario user);
	public ArrayList<Usuario> listarUsuarios();
	public Usuario actualizarUsuario(Usuario user);
	public Usuario eliminarUsuario(Usuario user);
	public boolean login(Usuario user);
}
