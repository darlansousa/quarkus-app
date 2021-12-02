package br.com.darlankenobi.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import lombok.*;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@UserDefinition
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;


    public static void adicionar(Usuario usuario){
        usuario.setPassword(BcryptUtil.bcryptHash(usuario.getPassword()));
        usuario.setRole(validarUserName(usuario.getUsername()));
        usuario.persist();
    }

    public static Optional<Usuario> findByUsernameOptional(String username){
        return find("username", username).firstResultOptional();
    }

    private static String validarUserName(String username) {
        if(username.equals("alura"))
            return "admin";
        return "user";
    }

    @JsonbTransient
    public String getPassword() {
        return password;
    }
}
