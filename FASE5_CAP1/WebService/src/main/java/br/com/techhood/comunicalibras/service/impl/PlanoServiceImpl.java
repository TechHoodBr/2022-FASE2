package br.com.techhood.comunicalibras.service.impl;

import br.com.techhood.comunicalibras.dto.PlanoDTO;
import br.com.techhood.comunicalibras.entity.PlanoEntity;
import br.com.techhood.comunicalibras.mapper.PlanoMapper;
import br.com.techhood.comunicalibras.repository.PlanoRepository;
import br.com.techhood.comunicalibras.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoServiceImpl implements PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private PlanoMapper planoMapper;

    @Override
    public List<PlanoDTO> buscarTodos() {
        List<PlanoEntity> planoEntities = planoRepository.findAll();
        return planoMapper.convert(planoEntities);
    }

    @Override
    public PlanoDTO buscarPorId(Long id) {
        PlanoEntity planoEntity = planoRepository.findById(id).orElse(null);
        return planoMapper.convert(planoEntity);
    }

    @Override
    public PlanoDTO inserir(PlanoDTO objeto) {
        objeto.setId(null);
        PlanoEntity planoEntity = planoMapper.convert(objeto);
        planoEntity = planoRepository.save(planoEntity);
        return planoMapper.convert(planoEntity);
    }

    @Override
    public PlanoDTO atualizarPorId(Long id, PlanoDTO objeto) {
        objeto.setId(id);
        PlanoEntity planoEntity = planoRepository.save(planoMapper.convert(objeto));
        return planoMapper.convert(planoEntity);
    }

    @Override
    public void deletarPorId(Long id) {
        planoRepository.deleteById(id);
    }
}
