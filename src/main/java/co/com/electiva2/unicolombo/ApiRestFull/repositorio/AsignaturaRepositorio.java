package co.com.electiva2.unicolombo.ApiRestFull.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.electiva2.unicolombo.ApiRestFull.modelo.Asignaturas;
@Repository
public interface AsignaturaRepositorio extends JpaRepository <Asignaturas, Integer>{
	
 public List<Asignaturas> findByNombre(String nombre);
 public List<Asignaturas> findBySemestre(Integer semestre);

}
