package co.com.electiva2.unicolombo.ApiRestFull.controlador;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.electiva2.unicolombo.ApiRestFull.modelo.Asignaturas;
import co.com.electiva2.unicolombo.ApiRestFull.servicio.AsignaturaServicio;

@RestController

@RequestMapping("/asignaturas")
public class AsignaturasControlador {
@Autowired
private AsignaturaServicio servicio;

@GetMapping()
public List<Asignaturas> ListarAsignaturas(){
	return servicio.ListarAsignaturas();
}

@GetMapping("nombre/{nombre}")
public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre){
    try {
        
        List<Asignaturas> Asignatura =  servicio.OptenerAsignaturasPorNombre(nombre);
        return new ResponseEntity<>(Asignatura,HttpStatus.OK); 
        
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@GetMapping("semestre/{semestre}")
public ResponseEntity<?> buscarPorSemestre(@PathVariable Integer semestre){
    try {
        
        List<Asignaturas> AsignaturaSemestre =  servicio.OptenerAsignaturasPorSemestre(semestre);
        return new ResponseEntity<>(AsignaturaSemestre,HttpStatus.OK); 
        
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@GetMapping("/id/{id}")
public ResponseEntity<Asignaturas> ObtenerAsignatura(@PathVariable Integer id) {
	try {
		Asignaturas Asignatura = servicio.OptenerAsignaturaPorId(id);
	 return new ResponseEntity<Asignaturas>(Asignatura,HttpStatus.OK);
	}catch(Exception exectcion){
		return new ResponseEntity<Asignaturas>(HttpStatus.NOT_FOUND);
	}
}

@PostMapping()
public ResponseEntity<Long> GuardarAsignatura(@RequestBody Asignaturas Asignatura) {
	servicio.GuardarAsignatura(Asignatura);
	Long cantidad = servicio.contar();
    return ResponseEntity.ok(cantidad);
}


@PutMapping("/id/{id}")
public ResponseEntity<?> ActualizarProductoPorId(@RequestBody Asignaturas Asignatura, @PathVariable Integer id){
	try {
		Asignaturas AsignaturaActual = servicio.OptenerAsignaturaPorId(id);

		AsignaturaActual.setNombre(Asignatura.getNombre());
		AsignaturaActual.setNombreCompleto(Asignatura.getNombreCompleto());
		AsignaturaActual.setDescripcion(Asignatura.getDescripcion());
		AsignaturaActual.setAreaConocimiento(Asignatura.getAreaConocimiento());
		AsignaturaActual.setCarrera(Asignatura.getCarrera());
		AsignaturaActual.setNumeroCreditos(Asignatura.getNumeroCreditos());
		AsignaturaActual.setContenidoTematico(Asignatura.getContenidoTematico());
		AsignaturaActual.setSemestre(Asignatura.getSemestre());
		AsignaturaActual.setProfesor(Asignatura.getProfesor());
		
		
		servicio.GuardarAsignatura( AsignaturaActual);
		return new ResponseEntity<Asignaturas>(HttpStatus.OK);
	}
	catch(Exception exeption){
		return new ResponseEntity<Asignaturas>(HttpStatus.NOT_FOUND);
	}
}


@DeleteMapping("/id/{id}")
public ResponseEntity<Long> EliminarAsignaturaPorId(@PathVariable Integer id) {
	servicio.EliminarAsignaturaPorId(id);
	Long cantidad = servicio.contar();
    return ResponseEntity.ok(cantidad);
	
}









}
