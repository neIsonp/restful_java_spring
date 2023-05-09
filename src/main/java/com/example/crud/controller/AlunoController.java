package com.example.crud.controller;

import lombok.AllArgsConstructor;
import com.example.crud.entity.Aluno;
import com.example.crud.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/alunos")
public class AlunoController {

    private AlunoService alunoService;

    @CrossOrigin(origins = "http://localhost:9090")

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {
        Aluno savedAluno = alunoService.createAluno(aluno);
        return new ResponseEntity<Aluno>(savedAluno, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable("id") Integer alunoId) {
        Aluno user = alunoService.getAlunoById((alunoId));
        return new ResponseEntity<Aluno>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.getAllALunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable("id") Integer alunoId, @RequestBody Aluno aluno) {
        aluno.setId(alunoId);
        Aluno updatedAluno = alunoService.updateAluno(aluno);
        return new ResponseEntity<>(updatedAluno, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable("id") Integer alunoId) {
        alunoService.deleteAluno(alunoId);
        return new ResponseEntity<>("aluno apagado com sucesso", HttpStatus.OK);
    }

}
