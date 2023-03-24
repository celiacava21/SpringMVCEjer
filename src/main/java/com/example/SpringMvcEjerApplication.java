package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Telefono;
import com.example.entities.Empleado.Genero;
import com.example.services.CorreoService;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvcEjerApplication  implements CommandLineRunner{

	@Autowired
	private CorreoService correoService;

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private TelefonoService telefonoService;



	public static void main(String[] args) {
		SpringApplication.run(SpringMvcEjerApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		
		departamentoService.save(Departamento.builder().nombre("Contabilidad").build());
		departamentoService.save(Departamento.builder().nombre("Finanzas").build());
		departamentoService.save(Departamento.builder().nombre("RRHH").build());

		empleadoService.save(Empleado.builder().id(1).nombre("Sarah")
		.apellidos("Benabidi Parra").fechaAlta(LocalDate.of(2000, Month.APRIL, 6)).genero(Genero.MUJER)
		.departamento(departamentoService.findById(1)).build());

		empleadoService.save(Empleado.builder().id(2).nombre("Judith").apellidos("Alende Martinez")
		.fechaAlta(LocalDate.of(1996, Month.AUGUST, 19)).genero(Genero.MUJER).departamento(departamentoService.findById(2)).build());

		empleadoService.save(Empleado.builder().id(3).nombre("Blanca").apellidos("Lopez Vidal").fechaAlta(LocalDate.of(2000, Month.AUGUST, 13))
		.genero(Genero.HOMBRE).departamento(departamentoService.findById(3)).build());

		telefonoService.save(Telefono.builder().id(1).numero("789876543")
		.empleado(empleadoService.findByÍd(1)).build());

		telefonoService.save(Telefono.builder().id(2).numero("897654345")
		.empleado(empleadoService.findByÍd(2)).build());

		telefonoService.save(Telefono.builder().id(3).numero("897654344")
		.empleado(empleadoService.findByÍd(3)).build());

		correoService.save(Correo.builder().id(1).email("correo1@gmail.com")
		.empleado(empleadoService.findByÍd(1)).build());

		correoService.save(Correo.builder().id(2).email("correo2@ggamil.com")
		.empleado(empleadoService.findByÍd(2)).build());

		correoService.save(Correo.builder().id(3).email("correo3@gmail.com")
		.empleado(empleadoService.findByÍd(3)).build());
		



	}

}
