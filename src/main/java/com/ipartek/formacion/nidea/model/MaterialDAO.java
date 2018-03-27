package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Recupera todos los materiales de la BBDD ordenado por id descendente
 * 
 * @author Curso
 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
 * 
 *
 */
public class MaterialDAO {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public ArrayList<Material> getAll() {
		ArrayList<Material> lista = new ArrayList<Material>();
		try {
			establecerConexionesABBDD();
			String sql = "SELECT id, nombre, precio FROM spoty.material";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			Material m = null;
			while (rs.next()) {
				m = new Material();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setPrecio(rs.getInt("precio"));
				lista.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO cerrar recursos abiertos [con, pst, rs]
		finally {
			cerrarRecursos();
		}
		return lista;
	}

	private Connection establecerConexionesABBDD() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			final String URL = "jdbc:mysql://192.168.0.42/spoty";
			con = DriverManager.getConnection(URL, "alumno", "alumno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	private void cerrarRecursos() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
