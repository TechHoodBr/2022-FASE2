import { Component } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { dateUtil } from '../../@core/utils/Date.util';

import { Router } from '@angular/router';
import { NbToastrService } from '@nebular/theme';
import { CertifiedService } from './certified.service';
import { Certified } from './certified.model';

@Component({
  selector: 'ngx-certified',
  styleUrls: ['./certified.component.scss'],
  templateUrl: './certified.component.html',
})
export class CertifiedComponent {

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
      skill: {
        title: 'Skill',
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
    private certifiedService: CertifiedService,
    private router: Router,
    private toastrService: NbToastrService) {
    this.retrieve();
  }

  retrieve() {
    this.certifiedService.getAll().subscribe((response: Certified[]) => {
      this.source.load(response);
    });
  }

  delete(certified: Certified) {
    this.certifiedService.deleteById(certified.id).subscribe((data) => {
      this.retrieve();
      this.toastrService.show(`Registro ID: ${certified.id}`, "Excluído com Sucesso !!", { status: 'success' });
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

  onEdit(data: Certified) {
    this.router.navigate(['/certified/edit/', data.id]);
  }

  onCreate() {
    this.router.navigate(['/certified/create']);
  }
}