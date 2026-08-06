package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.UsuarioEntity;
import com.example.projetospringbootcommysql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Permite requisições HTTP do FRONT-END
public class UsuarioController {

    @Autowired
    private UsuarioRepository comandos;

    @PostMapping
    public UsuarioEntity salvarUsuario(@RequestBody UsuarioEntity usuario) {
        // Usa a interface do repositório para salvar no banco de dados e retorna a entidade salva
        return comandos.save(usuario);
    }

    @GetMapping
    public List<UsuarioEntity> listarUsuarios(){
        // Retornar todos os valores da tabela de usuarios_entity
        return comandos.findAll();
        // Equivalente ao SELECT * FROM
    }

    @PutMapping("/{id}")
    public UsuarioEntity atualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioEntity dadoAtualizado) {

        // Busca o usuário pelo ID. Se não encontrar, lança um erro.
        UsuarioEntity usuarioAtual = comandos.findById(id).orElseThrow();

        // Define o ID do objeto recebido para garantir que vamos atualizar o registro correto
        usuarioAtual.setNome(dadoAtualizado.getNome());
        usuarioAtual.setEmail(dadoAtualizado.getEmail());
        return comandos.save(usuarioAtual);
    }

    @DeleteMapping("/{id}")
    public String apagarUsuario(
            @PathVariable Integer id
    ){
        // buscando usuario na tabela
        UsuarioEntity pessoa = comandos.findById(id).orElseThrow();
        String nome = pessoa.getNome();

        comandos.deleteById(id); // apagando dentro do banco

        return "Usuario "+nome+" deletado com sucesso!";
    }
}