package co.com.electiva2.unicolombo.ApiRestFull.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import co.com.electiva2.unicolombo.ApiRestFull.repositorio.AsignaturaRepositorio;
import co.com.electiva2.unicolombo.ApiRestFull.modelo.Asignaturas;

@Service
public class AsignaturaServicio {
@Autowired
private AsignaturaRepositorio Arepositorio;


public List<Asignaturas> ListarAsignaturas(){
	return Arepositorio.findAll();
}


public void GuardarAsignatura (Asignaturas Asignatura) {
Arepositorio.save(Asignatura); 
}


public void ActualizarAsignatura (Asignaturas Asignatura) {
Arepositorio.save(Asignatura);
}


public Asignaturas OptenerAsignaturaPorId(Integer Id) {
	return Arepositorio.findById(Id).get();
}

public List<Asignaturas> OptenerAsignaturasPorNombre(String nombre) {
	return Arepositorio.findByNombre(nombre);
	
}

public List<Asignaturas> OptenerAsignaturasPorSemestre(Integer semestre) {
	return Arepositorio.findBySemestre(semestre);
	
}


public long EliminarAsignaturaPorId(Integer Id) {
	Arepositorio.deleteById(Id);
	  long cantidadRegistros = Arepositorio.count();
	  return cantidadRegistros;
}


public  Long contar() {
   long cantidadRegistros = Arepositorio.count();
   return cantidadRegistros;
}


	
	
}
