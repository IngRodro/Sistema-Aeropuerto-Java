package Sistema_Aeropuerto.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Sistema_Aeropuerto.DAO.AeropuertoDao;


@Controller
public class ControllerAeropuerto {
	
	@Autowired
	private AeropuertoDao aeropuertoDao;
	
	@GetMapping("/")
	public String inicio(Model m) {
		var aeropuertos = aeropuertoDao.findAll();
		
		m.addAttribute("aeropuertos", aeropuertos);
		return"index";
		}
	
}
