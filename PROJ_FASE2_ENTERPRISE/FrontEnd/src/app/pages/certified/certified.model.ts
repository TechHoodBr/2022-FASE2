import { Skill } from '../skill/skill.model';

export interface Certifieds {
    certificado?: Certified;
}

export interface Certified {
    id?: Number;
    skill?: Skill;
    nome?: String;
    criado?: Date;
    atualizado?: Date;
    inativo?: Boolean;
}