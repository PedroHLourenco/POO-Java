package Controller;

import Model.Cliente;
import Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    //GET
    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public Cliente getAllById(@PathVariable Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente novoCliente){
        return clienteRepository.save(novoCliente);
    }

    //PUT ID
    @PutMapping("/{id")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente){
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(updatedCliente.getNome());
            cliente.setEndereco(updatedCliente.getEndereco());
            cliente.setTelefone(updatedCliente.getTelefone());
            return clienteRepository.save(cliente);
        })
                .orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }
}
