import { Plano } from "./Plano";
import { tipoUsuario } from "./TipoUsuario";

export class Usuario{
    public id: number;
    public nome: string;
    public login: string;
    public senha: string;
    public  avatar: string;
    public tipoUsuario: tipoUsuario;
    public plano: Plano;

}