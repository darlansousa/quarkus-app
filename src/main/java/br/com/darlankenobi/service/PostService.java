package br.com.darlankenobi.service;

import br.com.darlankenobi.model.Post;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/posts")
@RegisterRestClient(configKey = "posts-api")
public interface PostService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Post> findAll();
}
