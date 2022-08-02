package estudo.projetolojaapi.ApiRestClientes;

import estudo.projetolojaapi.model.Cliente;
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
    private String telefone;
    private String email;

    private LocalDate dataCadastro;


    public ClienteFormRequest(Long id, String nome, String cpf, LocalDate dataNascimento, String endereco, String telefone, String email, LocalDate dataCadastro) {
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

        return new Cliente(id, dataNascimento, cpf, nome, endereco, email, telefone);
    }

    public static ClienteFormRequest fromModel(Cliente cliente){
        return new ClienteFormRequest(cliente.getId(), cliente.getNome(),
                cliente.getCpf(), cliente.getNascimento(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail(), cliente.getDataCadastro());
    }
}
