package br.com.techhood.comunicalibras.service.impl;

import br.com.techhood.comunicalibras.dto.AulaDTO;
import br.com.techhood.comunicalibras.entity.AulaEntity;
import br.com.techhood.comunicalibras.mapper.AulaMapper;
import br.com.techhood.comunicalibras.repository.AulaRepository;
import br.com.techhood.comunicalibras.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private AulaMapper aulaMapper;

    @Override
    public List<AulaDTO> buscarTodos() {
        List<AulaEntity> aulaEntities = aulaRepository.findAll();
        return aulaMapper.convert(aulaEntities);
    }

    @Override
    public AulaDTO buscarPorId(Long id) {
        AulaEntity aulaEntity = aulaRepository.findById(id).orElse(null);
        return aulaMapper.convert(aulaEntity);
    }

    @Override
    public AulaDTO inserir(AulaDTO objeto) {
        objeto.setId(null);
        AulaEntity aulaEntity = aulaMapper.convert(objeto);
        aulaEntity = aulaRepository.save(aulaEntity);
        return aulaMapper.convert(aulaEntity);
    }

    @Override
    public AulaDTO atualizar(Long id, AulaDTO objeto) {
        objeto.setId(id);
        AulaEntity aulaEntity = aulaRepository.save(aulaMapper.convert(objeto));
        return aulaMapper.convert(aulaEntity);
    }

    @Override
    public void deletar(Long id) {
        aulaRepository.deleteById(id);
    }
}
