import { Component } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { dateUtil } from '../../@core/utils/date.util';
import { Skill } from './skill.model';
import { SkillService } from './skill.service';
import { Router } from '@angular/router';
import { NbToastrService } from '@nebular/theme';

@Component({
  selector: 'ngx-skill',
  styleUrls: ['./skill.component.scss'],
  templateUrl: './skill.component.html',
})
export class SkillComponent {

  settings = {
    actions: {
      columnTitle: "Ação",
      add: false,
      edit: false,
      delete: false,
      custom: [
        { name: 'edit', title: '<i class="nb-edit"></i>' },
        { name: 'delete', title: '<i class="nb-trash"></i>' }
      ],
    },
    columns: {
      id: {
        title: 'ID',
      },
      categoria: {
        title: 'Categoria',
        valuePrepareFunction: (data) => {
          return data.nome;
        },
        filterFunction: (cell?: any, search?: string) => {
          if (search.length > 0) {
            return cell.nome.toLowerCase().includes(search.toLowerCase());
          }
        }
      },
      nome: {
        title: 'Nome',
      },
      inativo: {
        title: 'Estado',
        valuePrepareFunction: (data) => {
          return data !== true ? "Habilitado" : "Desabilitado";
        },
        filterFunction: (cell?: any, search?: string) => {
          if (search.length > 0) {
            var cellValue = cell !== true ? "Habilitado" : "Desabilitado";
            return cellValue.toLowerCase().includes(search.toLowerCase());
          }
        }
      },
      atualizado: {
        title: 'Atualizado',
        filter: false,
        valuePrepareFunction: (data) => {
          return dateUtil.formatBR(data);
        }
      },
      criado: {
        title: 'Criado',
        filter: false,
        valuePrepareFunction: (data) => {
          return dateUtil.formatBR(data);
        }
      },
    },
  };

  public source: LocalDataSource = new LocalDataSource();

  constructor(
    private skillService: SkillService,
    private router: Router,
    private toastrService: NbToastrService) {
    this.retrieve();
  }

  retrieve() {
    this.skillService.getAll().subscribe((response: Skill[]) => {
      this.source.load(response);
    });
  }

  delete(skill: Skill) {
    this.skillService.deleteById(skill.id).subscribe((data) => {
      this.retrieve();
      this.toastrService.show(`Registro ID: ${skill.id}`, "Excluído com Sucesso !!", { status: 'success' });
    });
  }

  onCustom(event) {
    const eventType = event.action;
    const data = event.data;

    switch (eventType) {
      case "edit": {
        this.onEdit(data);
        break;
      }
      case "delete": {
        this.delete(data);
        break;
      }
    }
  }

  onEdit(data: Skill) {
    this.router.navigate(['/skill/edit/', data.id]);
  }

  onCreate() {
    this.router.navigate(['/skill/create']);
  }
}