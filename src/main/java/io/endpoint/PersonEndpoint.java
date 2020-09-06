package io.endpoint;

import io.model.entity.Person;
import io.service.impl.PersonDaoServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("persons")
@RequestScoped
public class PersonEndpoint {

  @Inject
  private PersonDaoServiceImpl userDaoSvc;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Person> getAll() {
    return this.userDaoSvc.findAll();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Person findById(@PathParam("id") final int id) {
    return this.userDaoSvc.read(id);
  }

  @POST
  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createPerson(Person person) {
    this.userDaoSvc.create(person);
    final String msg = "person #" + person.getId() + " created";
    return Response
      .status(Response.Status.CREATED)
      .entity(msg)
      .build();
  }
}
