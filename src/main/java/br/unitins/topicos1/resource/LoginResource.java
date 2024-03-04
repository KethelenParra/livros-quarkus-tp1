package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Login;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Login> findAll(){
        return Login.listAll();
    }

}
