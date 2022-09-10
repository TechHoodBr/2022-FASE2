package br.com.techhood.comunicalibras.service.impl;

import br.com.techhood.comunicalibras.dto.AulaMateriaisDTO;
import br.com.techhood.comunicalibras.entity.AulaMateriaisEntity;
import br.com.techhood.comunicalibras.mapper.AulaMateriaisMapper;
import br.com.techhood.comunicalibras.repository.AulaMateriaisRepository;
import br.com.techhood.comunicalibras.service.AulaMateriaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaMateriaisServiceImpl implements AulaMateriaisService {

    @Autowired
    private AulaMateriaisRepository aulaMateriaisRepository;

    @Autowired
    private AulaMateriaisMapper aulaMateriaisMapper;

    @Override
    public List<AulaMateriaisDTO> buscarTodos() {
        List<AulaMateriaisEntity> aulaMateriaisEntities = aulaMateriaisRepository.findAll();
        return aulaMateriaisMapper.convert(aulaMateriaisEntities);
    }

    @Override
    public AulaMateriaisDTO buscarPorId(Long id) {
        AulaMateriaisEntity aulaMateriaisEntity = aulaMateriaisRepository.findById(id).orElse(null);
        return aulaMateriaisMapper.convert(aulaMateriaisEntity);
    }

    @Override
    public AulaMateriaisDTO inserir(AulaMateriaisDTO objeto) {
        objeto.setId(null);
        AulaMateriaisEntity aulaMateriaisEntity = aulaMateriaisMapper.convert(objeto);
        aulaMateriaisEntity = aulaMateriaisRepository.save(aulaMateriaisEntity);
        return aulaMateriaisMapper.convert(aulaMateriaisEntity);
    }

    @Override
    public AulaMateriaisDTO atualizarPorId(Long id, AulaMateriaisDTO objeto) {
        objeto.setId(id);
        AulaMateriaisEntity aulaMateriaisEntity = aulaMateriaisRepository.save(aulaMateriaisMapper.convert(objeto));
        return aulaMateriaisMapper.convert(aulaMateriaisEntity);
    }

    @Override
    public void deletarPorId(Long id) {
        aulaMateriaisRepository.deleteById(id);
    }

    @Override
    public List<AulaMateriaisDTO> buscar(AulaMateriaisDTO objeto) {
        Example<AulaMateriaisEntity> exampleEntity = Example.of(aulaMateriaisMapper.convert(objeto));
        return aulaMateriaisMapper.convert(aulaMateriaisRepository.findAll(exampleEntity));
    }
}
