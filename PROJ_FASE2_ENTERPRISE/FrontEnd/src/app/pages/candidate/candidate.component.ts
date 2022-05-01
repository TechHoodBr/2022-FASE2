import { Component } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { dateUtil } from '../../@core/utils/date.util';

import { Router } from '@angular/router';
import { NbToastrService } from '@nebular/theme';
import { CandidateService } from './candidate.service';
import { Candidate } from './candidate.model';

@Component({
  selector: 'ngx-candidate',
  styleUrls: ['./candidate.component.scss'],
  templateUrl: './candidate.component.html',
})
export class CandidateComponent {

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
      nome: {
        title: 'Nome',
      },
      cpf: {
        title: 'CPF',
      },
      email: {
        title: 'E-mail',
      },
      telefone: {
        title: 'Telefone',
      },
      genero: {
        title: 'Genêro',
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
    private candidateService: CandidateService,
    private router: Router,
    private toastrService: NbToastrService) {
    this.retrieve();
  }

  retrieve() {
    this.candidateService.getAll().subscribe((response: Candidate[]) => {
      this.source.load(response);
    });
  }

  delete(candidate: Candidate) {
    this.candidateService.deleteById(candidate.id).subscribe((data) => {
      this.retrieve();
      this.toastrService.show(`Registro ID: ${candidate.id}`, "Excluído com Sucesso !!", { status: 'success' });
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

  onEdit(data: Candidate) {
    this.router.navigate(['/candidate/edit/', data.id]);
  }

  onCreate() {
    this.router.navigate(['/candidate/create']);
  }
}