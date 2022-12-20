package com.instituicao.instituto.service;

import com.instituicao.instituto.message.InstitutoSendMessage;
import com.instituicao.instituto.model.Action;
import com.instituicao.instituto.model.Curso;
import com.instituicao.instituto.model.Instituicao;
import com.instituicao.instituto.model.Jovem;
import com.instituicao.instituto.openfeign.CursoOpenFeign;
import com.instituicao.instituto.openfeign.JovemFeign;
import com.instituicao.instituto.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private InstitutoSendMessage institutoSendMessage;

    @Autowired
    private CursoOpenFeign cursoOpenFeign;

    @Autowired
    private JovemFeign jovemFeign;

    public Instituicao create(Instituicao instituicao) {
        institutoSendMessage.sendMessage(instituicao, Action.ADD);
        return instituicaoRepository.save(instituicao);
    }

    public Instituicao findById(String id) {
        return instituicaoRepository.findById(id).get();
    }

    public List<Instituicao> findAlll() {
        return instituicaoRepository.findAll();
    }

    public List<Instituicao> findAll(String id) {
        var objI = instituicaoRepository.findAll();
        var objC = cursoOpenFeign.get(id);
        List<Curso> cursos = new ArrayList<>();
        for (int i = 0; i < objI.size(); i++) {
            for (int j = 0; j < objC.size(); j++) {
                if (objI.get(i).getId() == objC.get(j).getInstituicoes().get(j).getId()) {
                    cursos.add(objC.get(j));
                }
                objI.get(i).setCursos(cursos);
            }
        }
        return objI;
    }

    public Instituicao update(Instituicao instituicao) {
        if (instituicao.getId() != null) {
            var obj = instituicaoRepository.findById(instituicao.getId());
            obj.get().setNome(instituicao.getNome());
            obj.get().setEndereco(instituicao.getEndereco());
            var jovens = jovemFeign.findAll();
            List<Jovem> jv = new ArrayList<>();
            for (int i = 0; i < jovens.size(); i++) {
                if (jovens.get(i).getInstituicoes().get(i).getId()==instituicao.getId()){
                    jv.add(jovens.get(i));
                }
            }
            obj.get().setJovens(jv);
            obj.get().getJovens().add(instituicao.getJovens().get(0));
            institutoSendMessage.sendMessage(instituicao, Action.UPDATE);
            instituicaoRepository.save(obj.get());
            return obj.get();
        }
        return null;
    }

    public void delete(String id) {
        if (id != null) {
            var obj = instituicaoRepository.findById(id);
            //apagar todos os jovens que pertencem a essa instituicao
            //apagar todos os cursos dos jovens desta instituicao
            institutoSendMessage.sendMessage(obj.get(), Action.REMOVE);
            instituicaoRepository.delete(obj.get());
        }
    }

    public Instituicao createCurso(String id, Curso curso) {
        if (id != null) {
            var objI = instituicaoRepository.findById(id).get();
            curso.getInstituicoes().add(objI);
            var objC = cursoOpenFeign.create(curso);
            objI.getCursos().add(objC);
            instituicaoRepository.save(objI);
            return objI;
        }
        return null;
    }

    public Instituicao deleteCurso(String id, String idCurso) {
        if (id != null) {
            var objI = instituicaoRepository.findById(id).get();
            cursoOpenFeign.delete(idCurso);
            var cursos = cursoOpenFeign.findAll();
            List<Curso> auxiliar = new ArrayList<>();
            for (Curso curso : cursos) {
                if (curso.getId() == idCurso) {
                    auxiliar.add(curso);
                }
            }
            objI.setCursos(auxiliar);
            instituicaoRepository.save(objI);
            return objI;
        }
        return null;
    }

    public Instituicao updateCurso(String id, Curso curso) {
        if (id != null) {
            var objI = instituicaoRepository.findById(id).get();
            cursoOpenFeign.update(curso);
            List<Curso> cursos = cursoOpenFeign.findAll();
            List<Curso> auxiliar = cursoOpenFeign.findAll();
            for (int i = 0; i < cursos.size(); i++) {
                if(cursos.get(i).getInstituicoes().get(i).getId()==id){
                    auxiliar.add(cursos.get(i));
                }
            }
            objI.setCursos(auxiliar);
            instituicaoRepository.save(objI);
            return objI;
        }
        return null;
    }
}
