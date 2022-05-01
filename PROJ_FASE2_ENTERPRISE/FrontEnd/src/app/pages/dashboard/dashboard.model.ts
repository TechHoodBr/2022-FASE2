import { Skills } from '../skill/skill.model';
import { Certifieds } from '../certified/certified.model';

export interface Candidate {
    id?: Number;
    nome?: String;
    cpf?: String;
    email?: String;
    telefone?: String;
    genero?: String;
    nascimento?: Date;
    skills?: Skills[];
    certificados?: Certifieds[];
    criado?: Date;
    atualizado?: Date;
    inativo?: Boolean;
}