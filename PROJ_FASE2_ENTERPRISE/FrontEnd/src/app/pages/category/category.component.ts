import { Component } from '@angular/core';
import { dateUtil } from '../../@core/utils/Date.util';
import { LocalDataSource } from 'ng2-smart-table';
import { CategoryService } from './category.service';
import { NbToastrService } from '@nebular/theme';
import { Router } from '@angular/router';
import { Category } from './category.model';

@Component({
  selector: 'ngx-category',
  styleUrls: ['./category.component.scss'],
  templateUrl: './category.component.html',
})
export class CategoryComponent {

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
    private categoryService: CategoryService,
    private router: Router,
    private toastrService: NbToastrService) {
    this.retrieve();
  }

  retrieve() {
    this.categoryService.getAll().subscribe((response: Category[]) => {
      this.source.load(response);
    });
  }

  delete(category: Category) {
    this.categoryService.deleteById(category.id).subscribe((data) => {
      this.retrieve();
      this.toastrService.show(`Registro ID: ${category.id}`, "Excluído com Sucesso !!", { status: 'success' });
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

  onEdit(data: Category) {
    this.router.navigate(['/category/edit/', data.id]);
  }

  onCreate() {
    this.router.navigate(['/category/create']);
  }
}
