package br.com.darlankenobi.model;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UsuarioTest {

    @Test
    public void testarSeFindByIdOptionalRetornausuarioCorreto() {
        PanacheMock.mock(Usuario.class);
        Usuario usuario = new Usuario();
        Optional<Usuario> optionalUsuario = Optional.of(usuario);
        Mockito.when(Usuario.findByUsernameOptional("alura"))
                .thenReturn(optionalUsuario);
        assertSame(usuario, Usuario.findByUsernameOptional("alura").get());
    }

}