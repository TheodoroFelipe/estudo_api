package estudo.projetolojaapi.ApiRestClientes;

import estudo.projetolojaapi.model.Cliente;
import estudo.projetolojaapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity salvar(@RequestBody ClienteFormRequest request){
        Cliente cliente = request.toModel();
        repository.save(cliente);
        return  ResponseEntity.ok(ClienteFormRequest.fromModel(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteFormRequest request){
        Optional<Cliente> clienteExistente = repository.findById(id);
        if (clienteExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = request.toModel();
        cliente.setId(id);
        repository.save(cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteFormRequest> getById(@PathVariable Long id){
        return repository
                .findById(id).map(ClienteFormRequest::fromModel).map(clienteFR -> ResponseEntity.ok(clienteFR)).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return repository.findById(id).map(cliente -> {repository.delete(cliente);
        return  ResponseEntity.noContent().build();})
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<ClienteFormRequest> getLista(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "cpf", required = false, defaultValue = "") String cpf,
            Pageable pageable
    ){ //stream o java transforma essa lista em stream
        return repository.buscarPorNomeCpf("%" + nome + "%",
                                             "%" + cpf + "%", pageable).map(ClienteFormRequest::fromModel);
    }
}
