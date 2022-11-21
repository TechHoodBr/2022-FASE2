import { Usuario } from './Usuario';

export class Aula {
  public id: number;
  public professor: Usuario = new Usuario();
  public titulo: string;
  public live_inicio: Date;
  public live_fim: Date;
  public descricao: string;
  public video: string;
}
