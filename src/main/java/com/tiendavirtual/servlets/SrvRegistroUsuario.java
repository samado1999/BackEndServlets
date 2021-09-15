package com.tiendavirtual.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SrvRegistroUsuario
 */
@WebServlet("/SrvRegistroUsuario")
public class SrvRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SrvRegistroUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String ced, user, pass;
		// ced = request.getParameter("ced");
		// user = request.getParameter("user");
		// pass = request.getParameter("pass");

		ced = "1";
		user = request.getParameter("txtUser");
		pass = request.getParameter("txtPass");

		String bd = "tiendagenerica";
		String login = "root";
		String password = "Mapache 777*";
		String url = "jdbc:mysql://localhost:3308/" + bd + "?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				if (ced != null) {

					PreparedStatement ps = connection
							.prepareStatement("SELECT usuario FROM usuarios WHERE usuario=? AND password=? LIMIT 1;");
					ps.setString(1, user);
					ps.setString(2, pass);
					ResultSet rs = ps.executeQuery();
					ArrayList<String> res = new ArrayList<>();
					while (rs.next()) {
						String userReturn = rs.getString(1);
						res.add(userReturn);
					}

					if (!res.isEmpty()) {
						res.forEach(c -> System.out.println(c));
						response.sendRedirect("Usuarios.html");  
					} else {
						System.out.println("USUARIO NO ENCONTRADO");
					}

					/*
					 * System.out.println("Conexion a base de datos " + bd + " OK\n");
					 * System.out.println("Ced: " + ced + " User: " + user + " Password: " + pass);
					 * Statement stmt = connection.createStatement(); stmt.
					 * executeUpdate("INSERT INTO usuarios(cedula_usuario, usuario, password) VALUES ("
					 * + "'" + ced + "'" + "," + "'" + user + "'" + "," + "'" + pass + "'" + ")");
					 */
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
