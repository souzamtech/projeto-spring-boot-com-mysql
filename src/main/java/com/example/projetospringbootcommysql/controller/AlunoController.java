package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.AlunoEntity;
import com.example.projetospringbootcommysql.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*") // Permite requisições HTTP do FRONT-END
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;


    @PostMapping
    public AlunoEntity salvarAluno(@RequestBody AlunoEntity aluno) {
        return alunoRepository.save(aluno);
    }


    @GetMapping
    public List<AlunoEntity> listarAlunos() {
        return alunoRepository.findAll();
    }


    @PutMapping("/{id}")
    public AlunoEntity atualizarAluno(@PathVariable Integer id, @RequestBody AlunoEntity dadoAtualizado) {


        AlunoEntity alunoAtual = alunoRepository.findById(id).orElseThrow();


        alunoAtual.setNome(dadoAtualizado.getNome());
        alunoAtual.setIdade(dadoAtualizado.getIdade());
        alunoAtual.setRegistroAluno(dadoAtualizado.getRegistroAluno());
        alunoAtual.setEmailInstitucional(dadoAtualizado.getEmailInstitucional());
        alunoAtual.setTurma(dadoAtualizado.getTurma());
        alunoAtual.setPeriodo(dadoAtualizado.getPeriodo());
        alunoAtual.setApresentacao(dadoAtualizado.getApresentacao());

        // Salva as alterações
        return alunoRepository.save(alunoAtual);
    }

    @DeleteMapping("/{id}")
    public String apagarAluno(@PathVariable Integer id) {
        // Verifica se o aluno existe antes de deletar
        AlunoEntity aluno = alunoRepository.findById(id).orElseThrow();

        alunoRepository.deleteById(id);
        return "Aluno deletado com sucesso";
    }
}