import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { NbToastrService } from '@nebular/theme';
import { Candidate } from './candidate.model';
import { CandidateService } from './candidate.service';
import { Skill } from '../skill/skill.model';
import { SkillService } from '../skill/skill.service';
import { CertifiedService } from '../certified/certified.service';
import { Certified } from '../certified/certified.model';

@Component({
  selector: 'ngx-candidate-form',
  styleUrls: ['./candidate-form.component.scss'],
  templateUrl: './candidate-form.component.html',
})
export class CandidateFormComponent {

  dataSkills: Skill[];
  dataCertifieds: Certified[];
  data: Candidate = {};
  formCandidate = this.formBuilder.group({
    nome: [null, Validators.required],
    cpf: [null, Validators.required],
    email: [null, Validators.required],
    telefone: [null, Validators.required],
    genero: [null, Validators.required],
    nascimento: [null, Validators.required],
    inativo: [null, Validators.required],
    skills: [null],
    certifieds: [null]
  });
  isNew: Boolean = true;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private candidateService: CandidateService,
    private formBuilder: FormBuilder,
    private toastrService: NbToastrService,
    private skillService: SkillService,
    private certifiedService: CertifiedService
  ) {
    this.retrieveSkills();
    this.retrieveCertifieds();
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isNew = false;
      this.candidateService.getById(id).subscribe((data) => {
        this.data = data;

        var skills = [];
        var certifieds = [];

        data.skills.forEach(element => {
          skills.push(String(element.skill.id));
        });
        data.certificados.forEach(element => {
          certifieds.push(String(element.certificado.id));
        });

        this.formCandidate.setValue({
          nome: data.nome,
          cpf: data.cpf,
          email: data.email,
          telefone: data.telefone,
          genero: data.genero,
          nascimento: data.nascimento,
          inativo: data.inativo,
          skills: skills,
          certifieds: certifieds
        })
      });
    }
  }

  retrieveSkills() {
    this.skillService.getAll().subscribe((response: Skill[]) => {
      this.dataSkills = response;
    });
  }

  retrieveCertifieds() {
    this.certifiedService.getAll().subscribe((response: Certified[]) => {
      this.dataCertifieds = response;
    });
  }

  onBack() {
    this.router.navigate(["/candidate"]);
  }

  onSubmit(): void {
    this.data.nome = this.formCandidate.value.nome;
    this.data.cpf = this.formCandidate.value.cpf;
    this.data.email = this.formCandidate.value.email;
    this.data.telefone = this.formCandidate.value.telefone;
    this.data.genero = this.formCandidate.value.genero;
    this.data.nascimento = this.formCandidate.value.nascimento;
    this.data.inativo = this.formCandidate.value.inativo;
    this.data.skills = [];
    this.data.certificados = [];

    if (this.isNew) {
      this.onCreate(this.data);
    } else {
      this.onUpdate(this.data);
    }
  }

  addSkills(id: Number) {
    const skillsSelects: Number[] = this.formCandidate.value.skills;
    var candidate: Candidate = { skills: [] };
    skillsSelects.forEach(element => {
      candidate.skills.push({ skill: { id: element } });
    });
    this.candidateService.postSkill(id, candidate.skills).subscribe(() => { });
  }

  addCertifieds(id: Number) {
    const certifiedsSelects: Number[] = this.formCandidate.value.certifieds;
    var candidate: Candidate = { certificados: [] };
    certifiedsSelects.forEach(element => {
      candidate.certificados.push({ certificado: { id: element } });
    });
    this.candidateService.postCertificado(id, candidate.certificados).subscribe(() => { });
  }

  onCreate(data: Candidate) {
    this.candidateService.post(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Criado com Sucesso !!", { status: 'success' });
      this.onBack();
      this.addSkills(data.id);
      this.addCertifieds(data.id);
    });
  }

  onUpdate(data: Candidate) {
    this.candidateService.put(data).subscribe((data) => {
      this.toastrService.show(`Registro ID: ${data.id}`, "Atualizado com Sucesso !!", { status: 'success' });
      this.onBack();
      this.addSkills(data.id);
      this.addCertifieds(data.id);
    });
  }
}