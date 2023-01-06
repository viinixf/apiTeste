package med.teste.apiTeste.controller;

import jakarta.transaction.Transactional;
import med.teste.apiTeste.endereco.Endereco;
import med.teste.apiTeste.medico.DadosCadastroMedico;
import med.teste.apiTeste.medico.Medico;
import med.teste.apiTeste.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Informando ao Spring que essa é a classe controller, na qual mapeia as requisições HTTP
@RestController
//Passada a URL do localhost, endpoint
@RequestMapping("medicos")
public class MedicoController {
    //Annotation do método Post(inserir)
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    /*Informando ao Spring que esse será o corpo da requisição */ // <- RequestBody
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
