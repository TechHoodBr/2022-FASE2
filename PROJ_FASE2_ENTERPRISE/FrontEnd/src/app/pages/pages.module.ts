import { NgModule } from '@angular/core';
import { NbActionsModule, NbButtonModule, NbCardModule, NbMenuModule, NbIconModule, NbInputModule, NbSelectModule, NbRadioModule, NbCheckboxModule, NbAccordionModule } from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { SkillComponent } from './skill/skill.component';
import { CategoryComponent } from './category/category.component';
import { CertifiedComponent } from './certified/certified.component';
import { CandidateComponent } from './candidate/candidate.component';
import { SkillService } from './skill/skill.service';
import { SkillFormComponent } from './skill/skill-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CategoryService } from './category/category.service';
import { CategoryFormComponent } from './category/category-form.component';
import { CertifiedFormComponent } from './certified/certified-form.component';
import { CertifiedService } from './certified/certified.service';
import { CandidateFormComponent } from './candidate/candidate-form.component';
import { CandidateService } from './candidate/candidate.service';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    MiscellaneousModule,
    Ng2SmartTableModule,
    NbCardModule,
    NbButtonModule,
    NbActionsModule,
    NbIconModule,
    NbInputModule,
    FormsModule,
    ReactiveFormsModule,
    NbSelectModule,
    NbRadioModule,
    NbCheckboxModule,
    NbAccordionModule
  ],
  declarations: [
    PagesComponent,
    SkillComponent,
    SkillFormComponent,
    CategoryComponent,
    CategoryFormComponent,
    CertifiedComponent,
    CertifiedFormComponent,
    CandidateComponent,
    CandidateFormComponent,
    DashboardComponent
  ],
  providers: [
    SkillService,
    CategoryService,
    CertifiedService,
    CandidateService
  ]
})
export class PagesModule {
}
