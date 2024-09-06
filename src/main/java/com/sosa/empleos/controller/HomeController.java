package com.sosa.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sosa.empleos.model.Vacante;


@Controller
public class HomeController {
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		
		model.addAttribute("vacante",vacante);
		
		return "detalle";
		
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos",lista);
		
		return "listado";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		/*model.addAttribute("mensaje", "Bienvenidos a empleos App");
		model.addAttribute("fecha", new Date());*/
		
		String nombre ="Auxiliar de Contabilidad";
		Date fechaPub = new Date();
		double salario = 9000.00;
		boolean vigente= true; 
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		return "home";
	}
	
	/*Metodo que regresa una lista de objetos de tipo vacante*/
	private List<Vacante> getVacantes(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		
		try {
			//Creamos la oferta de trabajo 1
			
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos ing. Civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(8500.0);
			vacante1.setDestacada(1);
			vacante1.setImagen("empresa1.png");
			
			//Creamos la oferta de trabajo 2
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Empresa importante solicia contador con 5 años de experiencia titulado");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacada(1);
			
			
			//Creamos la oferta de trabajo 3
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Empresa Internacional solicita ingeniero mecanico");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacada(0);
			vacante3.setImagen("empresa3.png");
			
			//Creamos la oferta de trabajo 4
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero ambiental");
			vacante4.setDescripcion("Lider en el mercado ing ambiental");
			vacante4.setFecha(sdf.parse("18-09-2019"));
			vacante4.setSalario(13500.0);
			vacante4.setDestacada(0);
			vacante4.setImagen("empresa4.png");
			
			/*Agregamos los 4 objetos de tipo vacante a la lista ... */
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		}catch(ParseException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return lista;
	}
	
}
