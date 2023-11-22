package Controller;

import Model.Pedido;
import Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    //GET
    @GetMapping
    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public Pedido getById(@PathVariable Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public Pedido createPedido(@RequestBody Pedido novoPedido){
        return pedidoRepository.save(novoPedido);
    }

    //PUT ID
    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido updatedPedido){
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setNomeCliente(updatedPedido.getNomeCliente());
            pedido.setQuantidade(updatedPedido.getQuantidade());
            pedido.setPreco(updatedPedido.getPreco());
            return pedidoRepository.save(pedido);
        })
                .orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        pedidoRepository.deleteById(id);
    }
}
