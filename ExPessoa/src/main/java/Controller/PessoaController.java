package Controller;

import Model.Pessoa;
import Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    //GET
    @GetMapping
    public List<Pessoa> getAllPessoa(){
        return pessoaRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public Pessoa getById(@PathVariable Long id){
        return pessoaRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public Pessoa createPessoa(@RequestBody Pessoa novaPessoa){
        return pessoaRepository.save(novaPessoa);
    }

    //PUT ID
    @PutMapping("/{id}")
    public Pessoa updatePessoa(@PathVariable Long id, @RequestBody Pessoa updatedPessoa){
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setNome(updatedPessoa.getNome());
            pessoa.setIdade(updatedPessoa.getIdade());
            pessoa.setSexo(updatedPessoa.getSexo());
            return pessoaRepository.save(pessoa);
        })
                .orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id){
        pessoaRepository.deleteById(id);
    }

}
