package com.example.projetospringbootcommysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//A entidade é a classe que representa uma tabela do banco de dados
@Entity //Aqui informa ao Spring que irá representar uma tabela no banco de dados
public class UsuarioEntity {
    //Colunas que serão criada dentro da minha tabela

    @Id //  Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String nome;
        private String email;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }