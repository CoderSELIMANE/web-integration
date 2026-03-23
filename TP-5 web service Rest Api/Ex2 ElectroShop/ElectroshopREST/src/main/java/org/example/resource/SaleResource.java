package org.example.resource;

import org.example.model.Sale;


import org.example.service.SaleService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/sales")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SaleResource {

    private SaleService service = SaleService.getInstance();

    // GET ALL
    @GET
    public Response getAllSales() {
        return Response.ok(service.getAllSales()).build();
    }

    // GET BY ID
    @GET
    @Path("/{id}")
    public Response getSale(@PathParam("id") Long id) {
        Sale sale = service.getSaleById(id);
        if (sale != null) return Response.ok(sale).build();
        return Response.status(Response.Status.NOT_FOUND)
                       .entity("{\"error\": \"Vente non trouvée\"}")
                       .build();
    }

    // ADD SALE
    @POST
    public Response addSale(Sale sale) {
        Sale created = service.addSale(sale);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    // UPDATE SALE
    @PUT
    @Path("/{id}")
    public Response updateSale(@PathParam("id") Long id, Sale sale) {
        Sale updated = service.updateSale(id, sale);
        if (updated != null) return Response.ok(updated).build();
        return Response.status(Response.Status.NOT_FOUND)
                       .entity("{\"error\": \"Vente non trouvée\"}")
                       .build();
    }

    // DELETE SALE
    @DELETE
    @Path("/{id}")
    public Response deleteSale(@PathParam("id") Long id) {
        boolean deleted = service.deleteSale(id);
        if (deleted) return Response.ok("{\"message\": \"Vente supprimée\"}").build();
        return Response.status(Response.Status.NOT_FOUND)
                       .entity("{\"error\": \"Vente non trouvée\"}").build();
    }

    // COUNT SALES
    @GET
    @Path("/count")
    public Response countSales() {
        return Response.ok("{\"count\": " + service.countSales() + "}").build();
    }
}