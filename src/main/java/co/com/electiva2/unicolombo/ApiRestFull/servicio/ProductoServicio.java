package co.com.electiva2.unicolombo.ApiRestFull.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import co.com.electiva2.unicolombo.ApiRestFull.repositorio.ProductoRepositorio;
import co.com.electiva2.unicolombo.ApiRestFull.modelo.producto;

@Service
public class ProductoServicio {
@Autowired
private  ProductoRepositorio Prepositorio;

public List<producto> ListarProductos(){
	return Prepositorio.findAll();
}

public void GuardarProducto (producto producto) {
Prepositorio.save(producto);
}

public producto OptenerProductoPorId(Integer Id) {
	return Prepositorio.findById(Id).get();
}

public void EliminarProductoPorId(Integer Id) {
	Prepositorio.deleteById(Id);
}

public  Long contar() {
   long cantidadRegistros = Prepositorio.count();
   return cantidadRegistros;
}

}
