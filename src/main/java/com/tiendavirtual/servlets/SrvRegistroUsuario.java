package com.tiendavirtual.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tiendavirtual.dao.UsuarioIMPL;
import com.tiendavirtual.dto.Usuario;

/**
 * Servlet implementation class SrvRegistroUsuario
 */
@WebServlet("/SrvRegistroUsuario")
public class SrvRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioIMPL userDAO;
	private Usuario userDTO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SrvRegistroUsuario() {
		super();
		// TODO Auto-generated constructor stub
		userDAO = new UsuarioIMPL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		userDTO = new Usuario();
		userDTO.setUsuario(request.getParameter("txtUser"));
		userDTO.setPassword(request.getParameter("txtPass"));
		boolean daoResponse = userDAO.login(userDTO);

		if (daoResponse) {
			response.sendRedirect("Usuarios.html");
		} else {
			System.out.println("USUARIO O CONTRASEÑA INCORRECTA");
			response.getWriter().append("USUARIO O CONTRASEÑA INCORRECTA");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("Hello from doPost");
		userDTO = new Usuario();
		
		
		
		userDTO.setCedulaUsuario(Long.valueOf("123"));
		userDTO.setEmailUsuario("test");
		userDTO.setNombreUsuario("test");
		userDTO.setPassword("test");
		userDTO.setUsuario("test");

		Usuario daoResponse = userDAO.crearUsuario(userDTO);

		if (daoResponse != null) {
			response.getWriter().append("USUARIO CREADO");
		} else {
			response.getWriter().append("USUARIO NO CREADO");
		}
	}

}
