package estudo.projetolojaapi.ApiRestClientes;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteFormRequest {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
    private String email;
    private String telefone;

    public ClienteFormRequest() {
        super();
    }
}
