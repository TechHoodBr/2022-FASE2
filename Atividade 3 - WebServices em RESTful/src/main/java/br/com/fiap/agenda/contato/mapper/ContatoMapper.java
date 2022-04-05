package br.com.fiap.agenda.contato.mapper;

import br.com.fiap.agenda.contato.dto.ContatoDTO;
import br.com.fiap.agenda.contato.entity.ContatoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContatoMapper {

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private TelefoneMapper telefoneMapper;

    @Autowired
    private GrupoMapper grupoMapper;

    public ContatoDTO converterDTO(ContatoEntity contatoEntity) {
        if (contatoEntity != null) {
            ContatoDTO contato = new ContatoDTO();
            contato.setId(contatoEntity.getId());
            contato.setNome(contatoEntity.getNome());
            contato.setSobrenome(contatoEntity.getSobrenome());
            contato.setApelido(contatoEntity.getApelido());
            contato.setFoto(contatoEntity.getFoto());
            contato.setTelefones(telefoneMapper.converterDTOS(contatoEntity.getTelefones()));
            contato.setEndereco(enderecoMapper.converterDTO(contatoEntity.getEndereco()));
            contato.setGrupo(grupoMapper.converterDTO(contatoEntity.getGrupo()));
            contato.setCriado(contatoEntity.getDataCriacao());
            contato.setAtivo(contatoEntity.getAtivo());
            return contato;
        }
        return null;
    }

    public List<ContatoDTO> converterDTOS(List<ContatoEntity> contatoEntities) {

        if (contatoEntities == null || contatoEntities.isEmpty()) {
            return null;
        }

        List<ContatoDTO> contatoDTOS = new ArrayList<>();

        for (ContatoEntity contatoEntity : contatoEntities) {
            contatoDTOS.add(converterDTO(contatoEntity));
        }
        return contatoDTOS;
    }
}
