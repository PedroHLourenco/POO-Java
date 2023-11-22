package Controller;

import Model.Consulta;
import Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaController(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    //GET
    @GetMapping
    public List<Consulta> getAllConsultas(){
        return consultaRepository.findAll();
    }

    //GET ID
    @GetMapping("/{id}")
    public Consulta getConsultaById(@PathVariable Long id){
        return consultaRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta){
        return consultaRepository.save(consulta);
    }

    //PUT ID
    @PutMapping("/{id}")
    public Consulta updateConsulta(@PathVariable Long id, @RequestBody Consulta updatedConsulta){
        return consultaRepository.findById(id).map(consulta -> {
            consulta.setNomePaciente(updatedConsulta.getNomePaciente());
            consulta.setCpf(updatedConsulta.getCpf());
            consulta.setNomeMedico(updatedConsulta.getNomeMedico());
            consulta.setCrm(updatedConsulta.getCrm());
            consulta.setEspecialidade(updatedConsulta.getEspecialidade());
            consulta.setHorario(updatedConsulta.getHorario());
            return consultaRepository.save(consulta);
        })
                .orElse(null);
    }

    //DELETE ID
    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable Long id){
        consultaRepository.deleteById(id);
    }
}
