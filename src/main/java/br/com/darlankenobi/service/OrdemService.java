package br.com.darlankenobi.service;

import br.com.darlankenobi.OrdemRepository;
import br.com.darlankenobi.model.Ordem;
import br.com.darlankenobi.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrdemService {

    @Inject
    private OrdemRepository ordemRepository;


    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Usuario usuario = Usuario.findByUsernameOptional(securityContext.getUserPrincipal().getName())
                .orElseThrow(NotFoundException::new);

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordem.setUserId(usuario.getId());

        ordemRepository.persist(ordem);
    }

    public List<Ordem> listAll(){
        return ordemRepository.listAll();
    }
}
