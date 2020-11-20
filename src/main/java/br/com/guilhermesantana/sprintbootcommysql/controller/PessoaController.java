package br.com.guilhermesantana.sprintbootcommysql.controller;

import br.com.guilhermesantana.sprintbootcommysql.controller.dto.PessoaRequest;
import br.com.guilhermesantana.sprintbootcommysql.controller.dto.PessoaResponse;
import br.com.guilhermesantana.sprintbootcommysql.model.Pessoa;
import br.com.guilhermesantana.sprintbootcommysql.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // GET para listar todos os usuarios
    @GetMapping("/")
    public List<PessoaResponse> findAll(){
        // Buscando pessoa do PessoaRepository
        var pessoas = pessoaRepository.findAll();
        return pessoas
                .stream()
                .map(PessoaResponse::converter)
                .collect(Collectors.toList());
    }

    // GET para listar apenas 1 usuario com o seu id
    @GetMapping("/{id}")
    public PessoaResponse findById(@PathVariable("id") Long id) {
        var pessoa = pessoaRepository.getOne(id);
        return PessoaResponse.converter(pessoa);
    }

    // POST para criar uma pessoa
    @PostMapping("/")
    public void savePerson(@RequestBody PessoaRequest pessoa) {
        var p = new Pessoa();
        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenome());
        pessoaRepository.save(p);
    }

    // PUT para alterar uma pessoa
    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody PessoaRequest pessoa) throws Exception {
        var p = pessoaRepository.findById(id);

        // Criando a condicao para que so altere pessoa que exista
        if(p.isPresent()) {
            var pessoaSave = p.get();
            pessoaSave.setNome(pessoa.getNome());
            pessoaSave.setSobrenome(pessoa.getSobrenome());
            pessoaRepository.save(pessoaSave);
        } else {
            throw new Exception("Pessoa nao encontrada");
        }
    }

    // DELETE para deletar uma pessoa
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) throws Exception {
        var p = pessoaRepository.findById(id);

        if(p.isPresent()) {
            var pessoaDelete = p.get();
            pessoaRepository.delete(pessoaDelete);
        } else {
            throw new Exception("Pessoa nao encontrada");
        }
    }

}
