package Controller;

import Model.Concessionaria;
import Repository.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concessionaria")
public class ConcessionariaController {
    private final ConcessionariaRepository concessionariaRepository;

    @Autowired
    public ConcessionariaController(ConcessionariaRepository concessionariaRepository){
        this.concessionariaRepository = concessionariaRepository;
    }

    //GET (listar todos)
    @GetMapping
    public List<Concessionaria> getAllConcessionaria(){
            return concessionariaRepository.findAll();
    }

    //GET by ID (listar por id)
    @GetMapping("/{id}")
    public Concessionaria getConcessionariaById(@PathVariable Long id){
        return concessionariaRepository.findById(id).orElse(null);
    }

    //POST (criar)
    @PostMapping
    public Concessionaria createConcessionaria(@RequestBody Concessionaria concessionaria){
        return concessionariaRepository.save(concessionaria);
    }

    //PUT by ID (editar por id)
    @PutMapping("/{id}")
    public Concessionaria updateConcessionaria(@PathVariable Long id, @RequestBody Concessionaria updatedConcessionaria){
        return concessionariaRepository.findById(id).map(concessionaria -> {
                concessionaria.setMarca(updatedConcessionaria.getMarca());
                concessionaria.setModelo(updatedConcessionaria.getModelo());
                concessionaria.setPlaca(updatedConcessionaria.getPlaca());
                return concessionariaRepository.save(concessionaria);
        })
                .orElse(null);
    }

    //DELETE by ID (excluir por id)
    @DeleteMapping("/{id}")
    public void deleteConcessionaria(@PathVariable Long id){
        concessionariaRepository.deleteById(id);
    }
}
