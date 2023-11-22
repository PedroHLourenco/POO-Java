package Controller;

import Model.Animal;
import Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    //GET (Listar todos)
    @GetMapping
    public List<Animal> getAllAnimais(){
        return animalRepository.findAll();
    }

    //GET by ID (Buscar por id)
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    //POST (criar)
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal){
        return animalRepository.save(animal);
    }

    //PUT by ID (editar por id)
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        return animalRepository.findById(id).map(animal -> {
            animal.setNome(updatedAnimal.getNome());
            animal.setEspecie(updatedAnimal.getEspecie());
            return animalRepository.save(animal);
        }).orElse(null);
    }

    //DELETE by ID (excluir por id)
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalRepository.deleteById(id);
    }
}

