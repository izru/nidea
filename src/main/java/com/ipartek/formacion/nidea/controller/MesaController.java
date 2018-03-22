package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// crear mesa
		Mesa m = new Mesa();
		// recoger parametros, SIEMPRE String
		String sPatas = request.getParameter("patas");
		String sDimension = request.getParameter("dimension");
		String sMaterial = request.getParameter("material");
		String sColor = request.getParameter("color");
		// si parametros son null recoger y crear mesa a medida
		if (sPatas != null) {
			// vengo del formulario y relleno con los datos del formulario
			int patas = Integer.parseInt(sPatas);
			m.setNumPatas(patas);
		}

		if (sMaterial != null) {
			// vengo del formulario y relleno con los datos del formulario
			int material = Integer.parseInt(sMaterial);
			m.setMaterial(material);
		}

		if (sDimension != null) {
			// vengo del formulario y relleno con los datos del formulario
			int dimension = Integer.parseInt(sDimension);
			m.setDimension(dimension);
		}

		if (sColor != null) {
			// vengo del formulario y relleno con los datos del formulario
			m.setColor(sColor);
		}

		// enviar atributos a la JSP
		request.setAttribute("mesa", m);// request.setAttribute(nombre, objeto);

		// ir a la JSP (que se llama mesa.jsp)
		request.getRequestDispatcher("mesa.jsp").forward(request, response);
		;
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
