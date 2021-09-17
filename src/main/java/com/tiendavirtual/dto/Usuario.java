package com.tiendavirtual.dto;

public class Usuario {
	private long cedulaUsuario;
	private String emailUsuario;
	private String nombreUsuario;
	private String password;
	private String usuario;

	public Usuario(long cedulaUsuario, String emailUsuario, String nombreUsuario, String password, String usuario) {
		super();
		this.cedulaUsuario = cedulaUsuario;
		this.emailUsuario = emailUsuario;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.usuario = usuario;
	}

	public Usuario() {
		super();
		this.cedulaUsuario = 0;
		this.emailUsuario = null;
		this.nombreUsuario = null;
		this.password = null;
		this.usuario = null;
	}

	public long getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
