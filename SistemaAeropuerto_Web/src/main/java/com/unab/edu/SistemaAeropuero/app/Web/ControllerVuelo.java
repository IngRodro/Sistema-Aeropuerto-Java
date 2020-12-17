package com.unab.edu.SistemaAeropuero.app.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unab.edu.SistemaAeropuero.app.DAO.VueloDao;

@Controller
public class ControllerVuelo {
	@Autowired
	private VueloDao vuelodao;

	@GetMapping("/vervuelos")
	public String inicio(Model m) {
		var vuelos = vuelodao.findAll();

		m.addAttribute("vuelos", vuelos);
		return "vuelos";
	}
}
