package Controller;

import Model.Empregado;
import Repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class EmpregadoController {
    private final EmpregadoRepository empregadoRepository;

    @Autowired
    public EmpregadoController(EmpregadoRepository empregadoRepository){
        this.empregadoRepository = empregadoRepository;
    }

    //GET (listar todos)
    @GetMapping
    public List<Empregado> getAllEmpregados(){
        return empregadoRepository.findAll();
    }

    //GET by ID (listar por id)
    @GetMapping("/{id}")
    public Empregado getEmpregadoById(@PathVariable Long id){
        return empregadoRepository.findById(id).orElse(null);
    }

    //POST (criar)
    @PostMapping
    public Empregado createEmpregado(@RequestBody Empregado empregado){
        return empregadoRepository.save(empregado);
    }

    //PUT by ID (editar)
    @PutMapping("/{id}")
    public Empregado updateEmpregado(@PathVariable Long id, @RequestBody Empregado updatedEmpregado){
        return empregadoRepository.findById(id).map(empregado -> {
            empregado.setNome(updatedEmpregado.getNome());
            empregado.setMatricula(updatedEmpregado.getMatricula());
            empregado.setSalario(updatedEmpregado.getSalario());
            return empregadoRepository.save(empregado);
        })
                .orElse(null);
    }

    //DELETE by ID (excluir por id)
    @DeleteMapping("/{id}")
    public void deleteEmpregado(@PathVariable Long id){
        empregadoRepository.deleteById(id);
    }
}
