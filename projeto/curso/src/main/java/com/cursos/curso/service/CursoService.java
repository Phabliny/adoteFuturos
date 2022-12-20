package com.cursos.curso.service;

import com.cursos.curso.message.CursoSendMessage;
import com.cursos.curso.model.Action;
import com.cursos.curso.model.Curso;
import com.cursos.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoSendMessage cursoSendMessage;

    public Curso create(Curso curso) {
        cursoSendMessage.sendMessage(curso, Action.ADD);
        return cursoRepository.save(curso);
    }

    public Curso findById(String id) {
        return cursoRepository.findById(id).get();
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso update(Curso curso) {
        if (curso.getId() != null) {
            var obj = cursoRepository.findById(curso.getId()).get();
            obj.setNome(curso.getNome());
            obj.setDescricao(curso.getDescricao());
            obj.setCargaHoraria(curso.getCargaHoraria());
            cursoRepository.save(obj);
            cursoSendMessage.sendMessage(curso, Action.UPDATE);
            return obj;
        }
        return null;
    }

    public void delete(String id) {
        if (id != null) {
            var obj = cursoRepository.findById(id).get();
            //apagar todos os cursos desse jovem e seu apoiador
            cursoSendMessage.sendMessage(obj, Action.REMOVE);
            cursoRepository.delete(obj);
        }
    }

    public List<Curso> listCursos(String id) {
        if (id != null) {
            return cursoRepository.getAllCursosDeUmaInstituição(id);
        }
        return null;
    }
}
