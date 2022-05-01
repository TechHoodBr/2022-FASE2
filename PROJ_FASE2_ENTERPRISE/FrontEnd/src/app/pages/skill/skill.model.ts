import { Category } from "../category/category.model";

export interface Skills {
    skill?: Skill;
}

export interface Skill {
    id?: Number;
    categoria?: Category;
    nome?: String;
    criado?: Date;
    atualizado?: Date;
    inativo?: Boolean;
}