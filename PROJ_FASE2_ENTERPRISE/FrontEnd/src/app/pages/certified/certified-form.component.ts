import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { NbToastrService } from '@nebular/theme';
import { Certified } from './certified.model';
import { CertifiedService } from './certified.service';
import { Skill } from '../skill/skill.model';
import { SkillService } from '../skill/skill.service';

@Component({
  selector: 'ngx-certified-form',
  styleUrls: ['./certified-form.component.scss'],
  templateUrl: './certified-form.component.html',
})
export class CertifiedFormComponent {

  dataSkills: Skill[];
  data: Certified = { skill: { id: null } };
  formCertified = this.formBuilder.group({
    skillId: [null, Validators.required],
    nome: [null, Validators.required],
    inativo: [null, Validators.required]
  });
  isNew: Boolean = true;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private certifiedService: CertifiedService,
    private formBuilder: FormBuilder,
    private toastrService: NbToastrService,
    private skillService: SkillService
  ) {
    this.retrieveSkill();
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isNew = false;
      this.certifiedService.getById(id).subscribe((data) => {
        this.data = data;
        this.formCertified.setValue({
          skillId: data.skill.id,
          nome: data.nome,
          inativo: data.inativo
        })
      });
    }
  }

  retrieveSkill() {
    this.skillService.getAll().subscribe((response: Skill[]) => {
      this.dataSkills = response;
    });
  }

  onBack() {
    this.router.navigate(["/certified"]);
  }

  onSubmit(): void {
    this.data.skill.id = this.formCertified.value.skillId;
    this.data.nome = this.formCertified.value.nome;
    this.data.inativo = this.formCertified.value.inativo;

    if (this.isNew) {
      this.onCreate(this.data);
    } else {
      this.onUpdate(this.data);
    }
  }

  onCreate(data: Certified) {
    this.certifiedService.post(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Criado com Sucesso !!", { status: 'success' });
      this.onBack();
    });
  }

  onUpdate(data: Certified) {
    this.certifiedService.put(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Atualizado com Sucesso !!", { status: 'success' });
      this.onBack();
    });
  }
}