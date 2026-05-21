package com.clinica.gerenciamento_prontuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome Obrigatório")
    private String nome;
    @NotBlank(message = "CPF Obrigatório")
    private String cpf;
    @NotBlank(message = "Idade Obrigatória")
    @Min(value = 1, message = "Insira um valor válido")
    private int idade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prontuario")
    private Prontuario prontuario;

    public Paciente(Long id, String nome, String cpf, int idade, Prontuario prontuario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.prontuario = prontuario;
    }

    public Paciente() {
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
