import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import { FeedComponent } from './pages/feed/feed.component';
import { MenuFeedComponent } from './componentes/menu-feed/menu-feed.component';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { ClassroomService } from './services/classroom.service';
import { ClassroomComponent } from './pages/classroom/classroom.component';
import localePt from '@angular/common/locales/pt-PT';
import { registerLocaleData } from '@angular/common';

registerLocaleData(localePt, 'pt');

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    WelcomeComponent,
    FeedComponent,
    MenuFeedComponent,
    ClassroomComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' },
    UserService,
    ClassroomService,
    CookieService,
    HttpClientModule,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
