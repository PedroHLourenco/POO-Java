package Controller;

import Model.Tarefa;
import Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepository;

    //GET
    @GetMapping
    public List<Tarefa> getAllTarefas(){
        return tarefaRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public Tarefa getAllById(@PathVariable Long id){
        return tarefaRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public Tarefa createTarefa(@RequestBody Tarefa novaTarefa){
        return tarefaRepository.save(novaTarefa);
    }

    //PUT ID
    @PutMapping("/{id}")
    public Tarefa updateTarefa(@PathVariable Long id, @RequestBody Tarefa updatedTarefa){
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefa.setDescricao(updatedTarefa.getDescricao());
            tarefa.setPrioridade(updatedTarefa.getPrioridade());
            tarefa.setConcluida(updatedTarefa.isConcluida());
            return tarefaRepository.save(tarefa);
        }).orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        tarefaRepository.deleteById(id);
    }
}
