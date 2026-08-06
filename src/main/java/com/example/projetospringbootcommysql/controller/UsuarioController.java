package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.UsuarioEntity;
// Certifique-se de importar a sua interface UsuarioRepository também
import com.example.projetospringbootcommysql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") //Permite requisições HTTP do FRONT-END
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
        //retornar todos os valores da tabela de usuarios_entity
        return comandos.findAll();
        // Equivalente ao SELECT * FROM
    }
}