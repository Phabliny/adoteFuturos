package com.apoiadores.apoiador.service;

import com.apoiadores.apoiador.message.ApoiadorSendMessage;
import com.apoiadores.apoiador.model.Action;
import com.apoiadores.apoiador.model.Apoiador;
import com.apoiadores.apoiador.openfeign.JovemFeign;
import com.apoiadores.apoiador.repository.ApoiadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApoiadorService {
    @Autowired
    private ApoiadorRepository apoiadorRepository;

    @Autowired
    private ApoiadorSendMessage apoiadorSendMessage;

    @Autowired
    private JovemFeign jovemFeign;

    public Apoiador create(Apoiador apoiador) {
        apoiadorSendMessage.sendMessage(apoiador, Action.ADD);
        return apoiadorRepository.save(apoiador);
    }

    public Apoiador findById(String id) {
        return apoiadorRepository.findById(id).get();
    }

    public List<Apoiador> findAll() {
        return apoiadorRepository.findAll();
    }

    public Apoiador update(Apoiador apoiador) {
        if (apoiador.getId() != null) {
            var obj = apoiadorRepository.findById(apoiador.getId()).get();
            obj.setNome(apoiador.getNome());
            obj.setTelefone(apoiador.getTelefone());
            apoiadorRepository.save(obj);
            apoiadorSendMessage.sendMessage(obj, Action.UPDATE);
            return obj;
        }
        return null;
    }

    public void delete(String id) {
        if (id != null) {
            var obj = apoiadorRepository.findById(id).get();
            apoiadorSendMessage.sendMessage(obj, Action.REMOVE);
            apoiadorRepository.delete(obj);
        }
    }

    public Apoiador apoiarJovemComCurso(Apoiador apoiador, String idJovem) {
        var ap = apoiadorRepository.findById(apoiador.getId()).get();
        var jovem = jovemFeign.findById(idJovem);
        jovem.setApoiador(apoiador);
        jovemFeign.updateApoiadorJovem(jovem);
        ap.getJovens().add(jovem);
        apoiadorRepository.save(ap);
        apoiadorSendMessage.sendMessage(ap, Action.UPDATE);
        return apoiador;
    }
}
