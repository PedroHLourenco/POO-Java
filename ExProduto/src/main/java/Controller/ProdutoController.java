package Controller;

import Model.Produto;
import Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //GET
    @GetMapping
    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public Produto createProduto(@RequestBody Produto novoProduto){
        return produtoRepository.save(novoProduto);
    }

    //PUT ID
    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto updatedProduto){
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(updatedProduto.getNome());
            produto.setDescricao(updatedProduto.getDescricao());
            produto.setPreco(updatedProduto.getPreco());
            return produtoRepository.save(produto);
        })
                .orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
}
