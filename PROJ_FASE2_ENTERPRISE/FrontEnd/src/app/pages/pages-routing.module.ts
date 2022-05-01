import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { NotFoundComponent } from './miscellaneous/not-found/not-found.component';
import { CategoryComponent } from './category/category.component';
import { SkillComponent } from './skill/skill.component';
import { CertifiedComponent } from './certified/certified.component';
import { CandidateComponent } from './candidate/candidate.component';
import { SkillFormComponent } from './skill/skill-form.component';
import { CategoryFormComponent } from './category/category-form.component';
import { CertifiedFormComponent } from './certified/certified-form.component';
import { CandidateFormComponent } from './candidate/candidate-form.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: 'ranking-candidates',
      component: DashboardComponent
    },
    {
      path: 'category',
      children: [
        {
          path: '',
          component: CategoryComponent
        },
        {
          path: 'create',
          component: CategoryFormComponent
        },
        {
          path: 'edit/:id',
          component: CategoryFormComponent
        }
      ]
    },
    {
      path: 'skill',
      children: [
        {
          path: '',
          component: SkillComponent
        },
        {
          path: 'create',
          component: SkillFormComponent
        },
        {
          path: 'edit/:id',
          component: SkillFormComponent
        }
      ]
    },
    {
      path: 'certified',
      children: [
        {
          path: '',
          component: CertifiedComponent
        },
        {
          path: 'create',
          component: CertifiedFormComponent
        },
        {
          path: 'edit/:id',
          component: CertifiedFormComponent
        }
      ]
    },
    {
      path: 'candidate',
      children: [
        {
          path: '',
          component: CandidateComponent
        },
        {
          path: 'create',
          component: CandidateFormComponent
        },
        {
          path: 'edit/:id',
          component: CandidateFormComponent
        }
      ]
    },
    {
      path: '',
      redirectTo: 'ranking-candidates',
      pathMatch: 'full',
    },
    {
      path: '**',
      component: NotFoundComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
