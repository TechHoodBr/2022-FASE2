import { Component, ViewChild } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { Router } from '@angular/router';
import { Candidate } from './dashboard.model';
import { CandidateService } from '../candidate/candidate.service';
import { SkillService } from '../skill/skill.service';
import { Skill } from '../skill/skill.model';
import { Certified } from '../certified/certified.model';
import { CertifiedService } from '../certified/certified.service';

@Component({
  selector: 'ngx-dashboard',
  styleUrls: ['./dashboard.component.scss'],
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent {

  @ViewChild('itemFilter', { static: true }) accordionItemFilter;

  search: Candidate = {};
  searchSkills: Number[] = [];
  searchCertifieds: Number[] = [];

  dataSkills: Skill[];
  dataCertifieds: Certified[];

  settings = {
    hideSubHeader: true,
    actions: {
      columnTitle: "",
      add: false,
      edit: false,
      delete: false,
      custom: [],
    },
    columns: {
      nome: {
        title: 'Candidato',
      },
      cpf: {
        title: 'CPF',
      },
      email: {
        title: 'E-mail',
      },
      skills: {
        title: 'Skill\'s',
        valuePrepareFunction: (data) => {
          var skills = "";
          data.forEach(element => {
            skills += element.skill.nome + ", ";
          });
          return skills.substring(0, skills.length - 2);
        },
      },
      certificados: {
        title: 'Certificado\'s',
        valuePrepareFunction: (data) => {
          var certifieds = "";
          data.forEach(element => {
            certifieds += element.certificado.nome + ", ";
          });
          return certifieds.substring(0, certifieds.length - 2);
        },
      },
    },
  };

  public source: LocalDataSource = new LocalDataSource();

  constructor(
    private candidateService: CandidateService,
    private skillService: SkillService,
    private certifiedService: CertifiedService,
    private router: Router) {
    this.retrieve({});
    this.retrieveSkills();
    this.retrieveCertifieds();
  }

  retrieve(search: Candidate) {
    this.candidateService.getSearch(search).subscribe((response: Candidate[]) => {
      this.source.load(response);
    });
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

  onSearch() {

    this.search.skills = [];
    this.search.certificados = [];

    this.searchSkills.forEach(element => {
      this.search.skills.push({ skill: { id: element } });
    });
    this.searchCertifieds.forEach(element => {
      this.search.certificados.push({ certificado: { id: element } });
    });
    this.retrieve(this.search);
    this.accordionItemFilter.toggle();
  }
}