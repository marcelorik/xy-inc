package br.com.xy.pois;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.xy.pois.bo.POIsBO;

@Path("/pois")
public class POIsService {

	@Inject
	private POIsBO poisBO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<POIs> listarPOIs() throws SQLException {
		return poisBO.listarPOIs();
	}

	@GET
	@Path("{x}/{y}/{distance}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<POIs> listarPOIsInteresse(@Min(message = "Valor de X inválido", value = 0) @PathParam("x") int x,
			@Min(message = "Valor de Y inválido", value = 0) @PathParam("y") int y,
			@Min(message = "Valor da distância inválido", value = 0) @PathParam("distance") int distance)
					throws SQLException {
		return poisBO.listarPOIs().stream().filter(poi -> poi.isNear(x, y, distance)).collect(Collectors.toList());
	}

	@POST
	@Path("{nome}/{x}/{y}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserirPOIs(@NotNull(message = "Valor do nome não pode ser nulo!") @PathParam("nome") String nome,
			@Min(message = "Valor de X inválido", value = 0) @PathParam("x") int x,
			@Min(message = "Valor de Y inválido", value = 0) @PathParam("y") int y) throws Exception {
		return Response.status(200).entity(poisBO.inserirPOIs(x, y, nome)).build();
	}

}
