package com.dogoo.employee.rest.application.api;

import com.dogoo.employee.rest.application.model.AccountRest;
import com.dogoo.employee.rest.application.model.PageRest;
import com.dogoo.employee.rest.application.service.AccountRestService;
import com.dogoo.employee.rest.application.validator.AccountRestValidate;
import com.dogoo.exception.api.BadRequestException;
import com.dogoo.exception.api.NotFoundException;
import com.dogoo.exception.api.*;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author phidx
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/accounts",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class AccountRestApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();

		singletons.add(new JacksonJsonProvider());

		singletons.add(this);

		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		/* Classes to wrap any exception into a JSON response */
		classes.add(UnAuthenticationExceptionMapper.class);
		classes.add(BadRequestExceptionMapper.class);
		classes.add(TokenRefreshExceptionMapper.class);
		classes.add(NotFoundExceptionMapper.class);
		/* add additional JAX-RS classes here */
		return classes;
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
	public Response getDetailAccount(@PathParam("accountId") Long accountId) throws PortalException, NotFoundException {
		accountRestValidate.validatorIsExists(accountId);
		AccountRest accountRest = accountRestService.getDetailAccount(accountId);
		return Response.status(HttpURLConnection.HTTP_OK).entity(accountRest).build();
	}


	@GET
	@Path("/pagination")
	@Produces(ContentTypes.APPLICATION_JSON)
	public PageRest getAccounts(  @QueryParam("page")  int page   ,@QueryParam("pageSize") int pageSize) throws NoSuchCategoryEntryException {
		return accountRestService.pagination(page,pageSize);

	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(AccountRest accountRest , @Context HttpServletRequest request) throws PortalException, BadRequestException {

		accountRestValidate.validatorForAddAccountRest(accountRest);
		accountRestValidate.validateScreeNameExists(
				ServiceContextFactory.getInstance(AccountRest.class.getName(), request).getCompanyId(),
				accountRest.getNewUser()
				);
		accountRestValidate.validateUseNameIsExists(accountRest.getNewUser(), accountRest.getEmail());
		AccountRest accountRest1 = accountRestService.addAccount(
				accountRest,
				Arrays.stream(accountRest.getRoles()).toArray(),
				ServiceContextFactory.getInstance(AccountRest.class.getName(), request)
		);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(accountRest1)
				.type(MediaType.APPLICATION_JSON).build();
	}



	@GET
	@Path("/get-accounts")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Page<AccountRest> getAccounts(@QueryParam("search") String search,
							@Context Filter filter, @Context Pagination pagination,
							@Context Sort[] sorts,
							@QueryParam("page")  int page   ,@QueryParam("pageSize") int pageSize,
					        @Context HttpServletRequest request) throws Exception {
		Pagination pagination1 = pagination.of(page,pageSize);

		// query roles
		Page<AccountRest> roles = accountRestService.getAllAccounts(search, filter, pagination1,
				sorts, ServiceContextFactory.getInstance(AccountRest.class.getName(), request));
		for (AccountRest item : roles.getItems()) {

			item.setCategoryRole(accountRestService.getRoles(item).getCategoryRole());
		}

	 return	roles;



	}



	@Reference
	private AccountRestService accountRestService;


	@Reference
	private AccountRestValidate accountRestValidate;

}