import { Component } from '@angular/core';
import { Skill } from './skill.model';
import { SkillService } from './skill.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { NbToastrService } from '@nebular/theme';
import { Category } from '../category/category.model';
import { CategoryService } from '../category/category.service';

@Component({
  selector: 'ngx-skill-form',
  styleUrls: ['./skill-form.component.scss'],
  templateUrl: './skill-form.component.html',
})
export class SkillFormComponent {

  dataCategorias: Category[];
  data: Skill = { categoria: { id: null } };
  formSkill = this.formBuilder.group({
    categoriaId: [null, Validators.required],
    nome: [null, Validators.required],
    inativo: [null, Validators.required]
  });
  isNew: Boolean = true;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private skillService: SkillService,
    private formBuilder: FormBuilder,
    private toastrService: NbToastrService,
    private categoryService: CategoryService
  ) {
    this.retrieveCategory();
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isNew = false;
      this.skillService.getById(id).subscribe((data) => {
        this.data = data;
        this.formSkill.setValue({
          categoriaId: data.categoria.id,
          nome: data.nome,
          inativo: data.inativo
        })
      });
    }
  }

  retrieveCategory() {
    this.categoryService.getAll().subscribe((response: Category[]) => {
      this.dataCategorias = response;
    });
  }

  onBack() {
    this.router.navigate(["/skill"]);
  }

  onSubmit(): void {
    this.data.categoria.id = this.formSkill.value.categoriaId;
    this.data.nome = this.formSkill.value.nome;
    this.data.inativo = this.formSkill.value.inativo;

    if (this.isNew) {
      this.onCreate(this.data);
    } else {
      this.onUpdate(this.data);
    }
  }

  onCreate(data: Skill) {
    this.skillService.post(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Criado com Sucesso !!", { status: 'success' });
      this.onBack();
    });
  }

  onUpdate(data: Skill) {
    this.skillService.put(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Atualizado com Sucesso !!", { status: 'success' });
      this.onBack();
    });
  }
}