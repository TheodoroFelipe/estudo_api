package estudo.projetolojaapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataNascimento;
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    public Cliente(Long id, LocalDate dataNascimento, String cpf, String nome, String endereco, String telefone, String email) {
        super();
    }

    public Cliente(Long id, LocalDate dataNascimento, String cpf, String nome, String endereco, String telefone, String email, Date dataCadastro) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public Cliente(LocalDate dataNascimento, String cpf, String nome, String endereco, String telefone, String email) {
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    @PrePersist
    public void prePersist(){
        setDataCadastro(Date.from(Instant.now()));
    }

    public Cliente() {

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email'" + email + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
