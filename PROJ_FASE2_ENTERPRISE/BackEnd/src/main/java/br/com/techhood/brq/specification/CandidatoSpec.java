package br.com.techhood.brq.specification;

import br.com.techhood.brq.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CandidatoSpec implements Specification<CandidatoEntity> {

    private final CandidatoEntity candidatoEntity;

    public CandidatoSpec(CandidatoEntity candidatoEntity) {
        this.candidatoEntity = candidatoEntity;
    }

    @Override
    public Predicate toPredicate(Root<CandidatoEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotBlank(candidatoEntity.getNome())) {
            predicates.add(cb.like(cb.lower(root.get("nome")), "%" + candidatoEntity.getNome().toLowerCase() + "%"));
        }

        if (StringUtils.isNotBlank(candidatoEntity.getEmail())) {
            predicates.add(cb.like(cb.lower(root.get("email")), "%" + candidatoEntity.getEmail().toLowerCase() + "%"));
        }

        if (StringUtils.isNotBlank(candidatoEntity.getCpf())) {
            predicates.add(cb.like(root.get("cpf"), "%" + candidatoEntity.getCpf() + "%"));
        }

        if (candidatoEntity.getSkills() != null && !candidatoEntity.getSkills().isEmpty()) {
            Join<CandidatoEntity, CandidatoSkillEntity> joinCandidatoSkill = root.join("skills");
            Join<CandidatoSkillEntity, SkillEntity> joinSkill = joinCandidatoSkill.join("skill");
            Expression<String> expressionSkill = joinSkill.get("id");
            predicates.add(expressionSkill.in(candidatoEntity.getSkills().stream().map(item -> item.getSkill().getId()).collect(Collectors.toList())));
        }

        if (candidatoEntity.getCertificados() != null && !candidatoEntity.getCertificados().isEmpty()) {
            Join<CandidatoEntity, CandidatoCertificadoEntity> joinCandidatoCertificado = root.join("certificados");
            Join<CandidatoCertificadoEntity, CertificadoEntity> joinCertificado = joinCandidatoCertificado.join("certificado");
            Expression<String> expressionCertificado = joinCertificado.get("id");
            predicates.add(expressionCertificado.in(candidatoEntity.getCertificados().stream().map(item -> item.getCertificado().getId()).collect(Collectors.toList())));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
