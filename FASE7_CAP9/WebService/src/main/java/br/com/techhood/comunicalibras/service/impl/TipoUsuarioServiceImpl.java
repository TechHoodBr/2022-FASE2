package br.com.techhood.comunicalibras.service.impl;

import br.com.techhood.comunicalibras.dto.TipoUsuarioDTO;
import br.com.techhood.comunicalibras.entity.TipoUsuarioEntity;
import br.com.techhood.comunicalibras.entity.UsuarioEntity;
import br.com.techhood.comunicalibras.mapper.TipoUsuarioMapper;
import br.com.techhood.comunicalibras.repository.TipoUsuarioRepository;
import br.com.techhood.comunicalibras.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private TipoUsuarioMapper tipoUsuarioMapper;

    @Override
    public List<TipoUsuarioDTO> buscarTodos() {
        List<TipoUsuarioEntity> tipoUsuarioEntities = tipoUsuarioRepository.findAll();
        return tipoUsuarioMapper.convert(tipoUsuarioEntities);
    }

    @Override
    public TipoUsuarioDTO buscarPorId(Long id) {
        TipoUsuarioEntity tipoUsuarioEntity = tipoUsuarioRepository.findById(id).orElse(null);
        return tipoUsuarioMapper.convert(tipoUsuarioEntity);
    }

    @Override
    public TipoUsuarioDTO inserir(TipoUsuarioDTO objeto) {
        objeto.setId(null);
        TipoUsuarioEntity tipoUsuarioEntity = tipoUsuarioMapper.convert(objeto);
        tipoUsuarioEntity = tipoUsuarioRepository.save(tipoUsuarioEntity);
        return tipoUsuarioMapper.convert(tipoUsuarioEntity);
    }

    @Override
    public TipoUsuarioDTO atualizarPorId(Long id, TipoUsuarioDTO objeto) {
        objeto.setId(id);
        TipoUsuarioEntity tipoUsuarioEntity = tipoUsuarioRepository.save(tipoUsuarioMapper.convert(objeto));
        return tipoUsuarioMapper.convert(tipoUsuarioEntity);
    }

    @Override
    public void deletarPorId(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }

    @Override
    public List<TipoUsuarioDTO> buscar(TipoUsuarioDTO objeto) {
        Example<TipoUsuarioEntity> exampleEntity = Example.of(tipoUsuarioMapper.convert(objeto));
        return tipoUsuarioMapper.convert(tipoUsuarioRepository.findAll(exampleEntity));
    }
}
