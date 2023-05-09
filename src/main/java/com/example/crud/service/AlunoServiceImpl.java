package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud.entity.Aluno;
import com.example.crud.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private AlunoRepository alunoRepository;

    @Override
    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno getAlunoById(Integer alunoId) {
        Aluno optionalALuno = alunoRepository.findById(alunoId).get();
        return optionalALuno;

    }

    @Override
    public List<Aluno> getAllALunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno updateAluno(Aluno aluno) {
        Aluno existingAluno = alunoRepository.findById(aluno.getId()).get();
        existingAluno.setNome(aluno.getNome());
        existingAluno.setEmail(aluno.getEmail());
        existingAluno.setNacionalidade(aluno.getNacionalidade());
        Aluno updatedAluno = alunoRepository.save(existingAluno);
        return updatedAluno;
    }

    @Override
    public void deleteAluno(Integer alunoId) {

        alunoRepository.deleteById(alunoId);

    }

}
