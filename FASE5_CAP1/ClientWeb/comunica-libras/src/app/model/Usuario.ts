import { Plano } from './Plano';
import { TipoUsuario } from './TipoUsuario';

export class Usuario {
  public id: number;
  public nome: string;
  public login: string;
  public senha: string;
  public avatar: string;
  public tipoUsuario: TipoUsuario = new TipoUsuario();
  public plano: Plano = new Plano();
}
