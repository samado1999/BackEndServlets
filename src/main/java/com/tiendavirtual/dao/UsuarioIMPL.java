package com.tiendavirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tiendavirtual.dto.Usuario;

public class UsuarioIMPL extends DBConnection implements UsuarioDAO {

	private PreparedStatement ps;

	@Override
	public Usuario crearUsuario(Usuario user) {
		// TODO Auto-generated method stub
		try {
			ps = this.Conectar().prepareStatement("INSERT INTO usuarios VALUES(?, ?, ?, ?, ?);");
			ps.setLong(1, user.getCedulaUsuario());
			ps.setString(2, user.getEmailUsuario());
			ps.setString(3, user.getNombreUsuario());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getUsuario());
			int res = ps.executeUpdate();
			if (res > 0) {
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		try {
			ps = this.Conectar().prepareStatement("SELECT * FROM usuarios;");
			ResultSet rs = ps.executeQuery();
			ArrayList<Usuario> res = new ArrayList<>();
			while (rs.next()) {
				Usuario user = new Usuario();
				user.setCedulaUsuario(rs.getLong(1));
				user.setEmailUsuario(rs.getString(2));
				user.setNombreUsuario(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setUsuario(rs.getString(5));
				res.add(user);
			}
			this.Cerrar();
			return res;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Usuario actualizarUsuario(Usuario user) {
		// TODO Auto-generated method stub
		try {
			ps = this.Conectar().prepareStatement("UPDATE usuarios SET email_usuario=?, nombre_usuario=?, password=?, usuario=? WHERE cedula_usuario=?;");
			ps.setString(1, user.getEmailUsuario());
			ps.setString(2, user.getNombreUsuario());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getUsuario());
			ps.setLong(5, user.getCedulaUsuario());
			int res = ps.executeUpdate();
			this.Cerrar();
			if (res > 0) {
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Usuario eliminarUsuario(Usuario user) {
		// TODO Auto-generated method stub
		try {
			ps = this.Conectar().prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?;");
			ps.setLong(1, user.getCedulaUsuario());
			int res = ps.executeUpdate();
			this.Cerrar();
			if (res > 0) {
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean login(Usuario user) {
		// TODO Auto-generated method stub
		try {
			ps = this.Conectar()
					.prepareStatement("SELECT usuario FROM usuarios WHERE usuario=? AND password=? LIMIT 1;");
			ps.setString(1, user.getUsuario());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			ArrayList<String> res = new ArrayList<>();
			while (rs.next()) {
				String userReturn = rs.getString(1);
				res.add(userReturn);
			}
			this.Cerrar();
			if (!res.isEmpty()) {
				res.forEach(c -> System.out.println(c));
				return true;
			} else {
				System.out.println("USUARIO NO ENCONTRADO");
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
