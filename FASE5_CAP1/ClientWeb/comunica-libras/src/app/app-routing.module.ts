import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClassroomComponent } from './pages/classroom/classroom.component';
import { FeedComponent } from './pages/feed/feed.component';

import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { WelcomeComponent } from './pages/welcome/welcome.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'feed', component: FeedComponent },
  { path: 'classroom/:id', component: ClassroomComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
