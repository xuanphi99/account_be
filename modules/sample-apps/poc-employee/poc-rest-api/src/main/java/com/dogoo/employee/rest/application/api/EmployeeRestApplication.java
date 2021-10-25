package com.dogoo.employee.rest.application.api;

import com.dogoo.employee.rest.application.model.EmployeeRest;
import com.dogoo.employee.rest.application.service.EmployeeRestService;
import com.dogoo.employee.rest.application.validator.EmployeeRestValidator;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.HttpURLConnection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vininh
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/rest-api",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
        },
        service = Application.class
)

public class EmployeeRestApplication extends Application {

    @Override
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
    @Path("/employee/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("employeeId") Long employeeId,EmployeeRest employeeRest) throws PortalException {
        employeeRestValidator.validatorEmployeeIsExists(employeeId);
        employeeRest = employeeRestService.getEmployee(employeeId);
        return Response.status(HttpURLConnection.HTTP_OK).entity(employeeRest).build();
    }

    @POST
    @Path("/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(EmployeeRest employeeRest) throws PortalException {
        employeeRestValidator.validatorForAddEmployeeRest(employeeRest);
        EmployeeRest employeeRest1 = employeeRestService.addEmployee(employeeRest, getServiceContext());
        return Response.status(HttpURLConnection.HTTP_OK)
                .entity(employeeRest1)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/employee/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEmployee(@PathParam("employeeId") Long employeeId) throws PortalException {
        employeeRestValidator.validatorEmployeeIsExists(employeeId);
        employeeRestService.deleteEmployee(employeeId);
    }

    @PUT
    @Path("/employee/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("employeeId") Long employeeId, EmployeeRest employeeRest) throws PortalException {
        employeeRestValidator.validatorForUpdateEmployeeRest(employeeId, employeeRest);
        EmployeeRest employeeRest1 = employeeRestService.updateEmployee(employeeId, employeeRest, getServiceContext());
        return Response.status(java.net.HttpURLConnection.HTTP_OK)
                .entity(employeeRest1)
                .build();
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(serviceContext.getUserId());
        serviceContext.setCompanyId(serviceContext.getCompanyId());
        serviceContext.setScopeGroupId(serviceContext.getScopeGroupId());
        return serviceContext;
    }

    @Reference
    private EmployeeRestService employeeRestService;
    @Reference
    private EmployeeRestValidator employeeRestValidator;

}