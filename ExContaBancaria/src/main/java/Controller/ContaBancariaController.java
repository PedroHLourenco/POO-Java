package Controller;

import Model.ContaBancaria;
import Repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contaBancaria")
public class ContaBancariaController {
    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    //GET
    @GetMapping
    public List<ContaBancaria> getAllContas(){
        return contaBancariaRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public ContaBancaria getById(@PathVariable Long id){
        return contaBancariaRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public ContaBancaria createConta(@RequestBody ContaBancaria novaConta){
        return contaBancariaRepository.save(novaConta);
    }

    //PUT ID
    @PutMapping
    public ContaBancaria updateConta(@PathVariable Long id, @RequestBody ContaBancaria updatedConta){
        return contaBancariaRepository.findById(id).map(contaBancaria -> {
            contaBancaria.setNomeCliente(updatedConta.getNomeCliente());
            contaBancaria.setTipoConta(updatedConta.getTipoConta());
            contaBancaria.setQuantia(updatedConta.getQuantia());
            return contaBancariaRepository.save(contaBancaria);
        })
                .orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        contaBancariaRepository.deleteById(id);
    }
}
