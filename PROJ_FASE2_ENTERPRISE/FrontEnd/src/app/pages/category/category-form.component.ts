import { Component } from '@angular/core';
import { Category } from './category.model';
import { CategoryService } from './category.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { NbToastrService } from '@nebular/theme';

@Component({
  selector: 'ngx-category-form',
  styleUrls: ['./category-form.component.scss'],
  templateUrl: './category-form.component.html',
})
export class CategoryFormComponent {

  data: Category = {};
  formCategory = this.formBuilder.group({
    nome: [null, Validators.required],
    inativo: [null, Validators.required]
  });
  isNew: Boolean = true;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private categoryService: CategoryService,
    private formBuilder: FormBuilder,
    private toastrService: NbToastrService
  ) {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isNew = false;
      this.categoryService.getById(id).subscribe((data) => {
        this.data = data;
        this.formCategory.setValue({
          nome: data.nome,
          inativo: data.inativo
        })
      });
    }
  }

  onBack() {
    this.router.navigate(["/category"]);
  }

  onSubmit(): void {
    this.data.nome = this.formCategory.value.nome;
    this.data.inativo = this.formCategory.value.inativo;

    if (this.isNew) {
      this.onCreate(this.data);
    } else {
      this.onUpdate(this.data);
    }
  }

  onCreate(data: Category) {
    this.categoryService.post(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Criado com Sucesso !!", { status: 'success' });
      this.onBack();
    });
  }

  onUpdate(data: Category) {
    this.categoryService.put(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Atualizado com Sucesso !!", { status: 'success' });
      this.onBack();
    });
  }
}