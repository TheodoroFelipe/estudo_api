package estudo.projetolojaapi.ApiRestClientes;

import com.fasterxml.jackson.annotation.JsonFormat;
import estudo.projetolojaapi.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ClienteFormRequest {

    private Long id;
    private String nome;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;


    public ClienteFormRequest(Long id, String nome, String cpf, LocalDate dataNascimento, String endereco, String telefone, String email, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public ClienteFormRequest() {
        super();
    }

    public Cliente toModel(){

        return new Cliente(dataNascimento, cpf, nome, endereco, telefone, email);
    }

    public static ClienteFormRequest fromModel(Cliente cliente){
        return new ClienteFormRequest(cliente.getId(), cliente.getNome(),
                cliente.getCpf(), cliente.getDataNascimento(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail(), cliente.getDataCadastro());
    }
}
