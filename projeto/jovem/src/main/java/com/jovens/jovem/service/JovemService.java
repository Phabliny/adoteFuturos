package com.jovens.jovem.service;
import com.jovens.jovem.message.JovemSendMessage;
import com.jovens.jovem.model.Action;
import com.jovens.jovem.model.Instituicao;
import com.jovens.jovem.model.Jovem;
import com.jovens.jovem.openfeign.CursoFeign;
import com.jovens.jovem.openfeign.InstitutoFeign;
import com.jovens.jovem.repository.JovemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JovemService {
    @Autowired
    private JovemRepository jovemRepository;

    @Autowired
    private JovemSendMessage jovemSendMessage;

    @Autowired
    private InstitutoFeign institutoFeign;

    @Autowired
    private CursoFeign cursoFeign;

    public Jovem create(Jovem jovem, String id){
        var instId = institutoFeign.findById(id);
        instId.getJovens().add(jovem);
        jovem.getInstituicoes().add(instId);
        var instAll = institutoFeign.findAlll();
        List<Instituicao> it = new ArrayList<>();
        institutoFeign.update(instId);
        jovemSendMessage.sendMessage(jovem, Action.ADD);
        return jovemRepository.save(jovem);
    }

    public Jovem findById(String id){
        return jovemRepository.findById(id).get();
    }

    public List<Jovem> findAll(){
        return jovemRepository.findAll();
    }

    public Jovem update(Jovem jovem){
        if(jovem.getId()!=null){
            var obj = jovemRepository.findById(jovem.getId()).get();
            obj.setApoiado(jovem.getApoiado());
            obj.setApoiador(jovem.getApoiador());
            obj.setCurso(jovem.getCurso());
            obj.setGenero(jovem.getGenero());
            obj.setDescricao(jovem.getDescricao());
            obj.setInstituicoes(jovem.getInstituicoes());
            jovemRepository.save(obj);
            jovemSendMessage.sendMessage(obj, Action.UPDATE);
            return obj;
        }
        return null;
    }

    public Jovem updateApoiadorJovem(Jovem jovem){
        if(jovem.getId()!=null){
            var obj = jovemRepository.findById(jovem.getId()).get();
            obj.setApoiado(true);
            obj.setApoiador(jovem.getApoiador());
            jovemRepository.save(obj);
            jovemSendMessage.sendMessage(obj, Action.UPDATE);
            return obj;
        }
        return null;
    }

    public void delete(String id){
        if(id!=null){
            var obj = jovemRepository.findById(id).get();
            //apagar todos os cursos desse jovem e seu apoiador
            jovemSendMessage.sendMessage(obj, Action.REMOVE);
            jovemRepository.delete(obj);
        }
    }
}
