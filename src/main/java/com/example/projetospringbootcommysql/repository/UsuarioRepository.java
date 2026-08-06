package com.example.projetospringbootcommysql.repository;

import com.example.projetospringbootcommysql.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Nessa interface, eu vou importar métodos que representam comandos SQL
//TENHO QUE ESPECIFICAR A CLASSE QUE EU  USAR  COM
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
