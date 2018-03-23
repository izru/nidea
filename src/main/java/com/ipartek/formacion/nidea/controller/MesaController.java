package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Material;
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

		// si parametros son null recoger y crear mesa a medida
		if (sPatas != null) {
			// vengo del formulario y relleno con los datos del formulario
			int patas = Integer.parseInt(sPatas);
			m.setNumPatas(patas);
			/*
			 * si hubisemos usado arrays String sMaterial =
			 * request.getParameter("material"); // vengo del formulario y relleno con los
			 * datos del formulario int material = Integer.parseInt(sMaterial);
			 * m.setMaterial(material);
			 */

			// vengo del formulario y relleno con los datos del formulario
			int dimension = Integer.parseInt(sDimension);
			m.setDimension(dimension);

			String sCustom = request.getParameter("custom");
			if (sCustom == null) {
				m.setCustom(false);
			} else { // viene 'on'
				m.setCustom(true);

				// color
				String color = request.getParameter("color");
				m.setColor(color);
			}

			String sMaterialId = request.getParameter("material");
			int idMaterial = Integer.parseInt(sMaterialId);
			m.setMaterial(new Material(idMaterial));

		}

		// enviar atributos a la JSP
		request.setAttribute("mesa", m);// request.setAttribute(nombre, objeto);
		request.setAttribute("materiales", Material.NOMBRES);
		request.setAttribute("materialesCodigo", Material.IDS);
		/*
		 * si hubisesemos usado array en vez de clase request.setAttribute("materiales",
		 * Mesa.MATERIALES_LISTA); request.setAttribute("materialesCodigo",
		 * Mesa.MATERIALES_LISTA_CODIGO);
		 */

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
