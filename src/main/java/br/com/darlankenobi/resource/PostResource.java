package br.com.darlankenobi.resource;

import br.com.darlankenobi.model.Post;
import br.com.darlankenobi.service.PostService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/posts")
public class PostResource {

    @Inject
    @RestClient
    private PostService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> findAll(){
        return bitcoinService.findAll();
    }


}
