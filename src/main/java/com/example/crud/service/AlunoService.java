package com.example.crud.service;

import java.util.List;

import com.example.crud.entity.Aluno;

public interface AlunoService {

    Aluno createAluno(Aluno aluno);

    Aluno getAlunoById(Integer alunoId);

    List<Aluno> getAllALunos();

    Aluno updateAluno(Aluno aluno);

    void deleteAluno(Integer alunoId);

}
