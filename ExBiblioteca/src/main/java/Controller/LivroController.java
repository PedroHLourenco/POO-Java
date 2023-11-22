package Controller;

import Model.Livro;
import Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    //GET
    @GetMapping
    public List<Livro> getAllLivros(){
        return livroRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Long id){
        return livroRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public Livro createLivro(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }

    //PUT ID
    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Long id, @RequestBody Livro updatedLivro){
        return livroRepository.findById(id).map(livro -> {
            livro.setNomeLivro(updatedLivro.getNomeLivro());
            livro.setAutor(updatedLivro.getAutor());
            livro.setAnoPublicacao(updatedLivro.getAnoPublicacao());
            return livroRepository.save(livro);
        })
                .orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deleteLIvro(@PathVariable Long id){
        livroRepository.deleteById(id);
    }

}
