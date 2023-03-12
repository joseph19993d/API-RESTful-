package co.com.electiva2.unicolombo.ApiRestFull.controlador;


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

import java.util.List;

import co.com.electiva2.unicolombo.ApiRestFull.modelo.producto;
import co.com.electiva2.unicolombo.ApiRestFull.servicio.ProductoServicio;



@RestController
//@Slf4j
@RequestMapping("/productos")
public class ProductoControlador {
	@Autowired
	private ProductoServicio servicio;
	
	@GetMapping()
	public List<producto> ListarProductos(){
		return servicio.ListarProductos();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<producto> ObtenerProducto(@PathVariable Integer id) {
		try {
		 producto producto = servicio.OptenerProductoPorId(id);
		 
		 return new ResponseEntity<producto>(producto,HttpStatus.OK);
		}catch(Exception exectcion){
			return new ResponseEntity<producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Long> GuardarProducto(@RequestBody producto producto) {
		servicio.GuardarProducto(producto);
		Long cantidad = servicio.contar();
        return ResponseEntity.ok(cantidad);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<?> ActualizarProducto(@RequestBody producto producto, @PathVariable Integer id){
		try {
			producto productoActual = servicio.OptenerProductoPorId(id);
			
			productoActual.setNombre(producto.getNombre());

			productoActual.setPrecio(producto.getPrecio());
			
			
			servicio.GuardarProducto( productoActual);
			return new ResponseEntity<producto>(HttpStatus.OK);
		}
		catch(Exception exeption){
			return new ResponseEntity<producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/id/{id}")
	public  ResponseEntity<Long> EliminarProducto(@PathVariable Integer id) {
		servicio.EliminarProductoPorId(id);
		Long cantidad = servicio.contar();
        return ResponseEntity.ok(cantidad);
	}
	
	@GetMapping("/contar")
	public ResponseEntity<Long> getCount() {
		Long cantidad = servicio.contar();
        return ResponseEntity.ok(cantidad);
    }
	
	

	
}
