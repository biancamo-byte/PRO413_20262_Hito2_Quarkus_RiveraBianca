package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoResource {

    private static List<Producto> listaProductos = new ArrayList<>();

    static {
        listaProductos.add(new Producto("1", "Laptop", 1200.00));
        listaProductos.add(new Producto("2", "Mouse", 25.50));
    }

    @GET
    public List<Producto> obtenerTodos() {
        return listaProductos;
    }

    @POST
    public Response agregarProducto(Producto nuevoProducto) {
        listaProductos.add(nuevoProducto);
        return Response.status(Response.Status.CREATED).entity(nuevoProducto).build();
    }
}