package br.com.fiap.supermercado.mapper;

import br.com.fiap.supermercado.dto.EnderecoDTO;
import br.com.fiap.supermercado.entity.EnderecoEntity;
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
