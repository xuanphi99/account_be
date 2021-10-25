package com.dogoo.poc.account.application;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.*;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dogoo.poc.account.application.model.AccountRest;
import com.dogoo.poc.account.application.service.AccountRestService;
import com.dogoo.poc.account.application.validator.AccountRestValidate;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import javax.ws.rs.core.Application;

/**
 * @author Administrator
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/accounts",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class AccountRestApiApplication extends Application {


	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();

		singletons.add(new JacksonJsonProvider());

		singletons.add(this);

		return singletons;
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

	@GET
	@Path("/detail/{accountId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee(@PathParam("accountId") Long accountId, AccountRest accountRest) throws PortalException {
		accountRestValidate.validatorIsExists(accountId);
		accountRest = accountRestService.getDetailAccount(accountId);
		return Response.status(HttpURLConnection.HTTP_OK).entity(accountRest).build();
	}


	@Reference
	private AccountRestService accountRestService;

	@Reference
	private AccountRestValidate accountRestValidate;


}