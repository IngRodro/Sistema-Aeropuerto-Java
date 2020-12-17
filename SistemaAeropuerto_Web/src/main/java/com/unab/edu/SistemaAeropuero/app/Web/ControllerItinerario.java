package com.unab.edu.SistemaAeropuero.app.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unab.edu.SistemaAeropuero.app.DAO.ItinerarioDao;
import com.unab.edu.SistemaAeropuero.app.DAO.VueloDao;

@Controller
public class ControllerItinerario {
	@Autowired
	private ItinerarioDao itiDao;

	@GetMapping("/veritinerarios")
	public String inicio(Model m) {
		var itinerarios = itiDao.findAll();

		m.addAttribute("itinerarios", itinerarios);
		return "itinerario";
	}
}
