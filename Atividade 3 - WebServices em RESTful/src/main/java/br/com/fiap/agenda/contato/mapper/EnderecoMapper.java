package br.com.fiap.agenda.contato.mapper;

import br.com.fiap.agenda.contato.dto.ContatoDTO;
import br.com.fiap.agenda.contato.dto.EnderecoDTO;
import br.com.fiap.agenda.contato.entity.ContatoEntity;
import br.com.fiap.agenda.contato.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnderecoMapper {

    @Autowired
    private CidadeMapper cidadeMapper;

    @Autowired
    private EstadoMapper estadoMapper;

    @Autowired
    private PaisMapper paisMapper;

    public EnderecoDTO converterDTO(EnderecoEntity enderecoEntity) {
        if (enderecoEntity != null) {
            EnderecoDTO endereco = new EnderecoDTO();
            endereco.setId(enderecoEntity.getId());
            endereco.setEndereco(enderecoEntity.getEndereco());
            endereco.setNumero(enderecoEntity.getNumero());
            endereco.setCep(enderecoEntity.getCep());
            endereco.setComplemento(enderecoEntity.getComplemento());
            endereco.setCidade(cidadeMapper.converterDTO(enderecoEntity.getCidade()));
            endereco.setEstado(estadoMapper.converterDTO(enderecoEntity.getEstado()));
            endereco.setPais(paisMapper.converterDTO(enderecoEntity.getPais()));
            endereco.setCriado(enderecoEntity.getDataCriacao());
            endereco.setAtivo(enderecoEntity.getAtivo());
            return endereco;
        }
        return null;
    }

    public List<EnderecoDTO> converterDTOS(List<EnderecoEntity> enderecoEntities) {

        if (enderecoEntities == null || enderecoEntities.isEmpty()) {
            return null;
        }

        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (EnderecoEntity enderecoEntity : enderecoEntities) {
            enderecoDTOS.add(converterDTO(enderecoEntity));
        }
        return enderecoDTOS;
    }
}
