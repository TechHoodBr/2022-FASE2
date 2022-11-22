import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Subject, takeUntil } from 'rxjs';
import { Usuario } from 'src/app/model/Usuario';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit, OnDestroy {
  usuario: Usuario = new Usuario();
  private _unsubscribeAll: Subject<any> = new Subject<any>();

  constructor(
    private _userService: UserService,
    private _router: Router,
    private _cookieService: CookieService
  ) {}

  ngOnInit(): void {
    window.scroll(0, 0);
  }

  ngOnDestroy(): void {
    this._unsubscribeAll.next(null);
    this._unsubscribeAll.complete();
  }

  signIn() {
    if (!this.usuario.login && !this.usuario.senha) {
      alert('Login / Senha inválido !');
    } else {
      this._userService
        .login(this.usuario)
        .pipe(takeUntil(this._unsubscribeAll))
        .subscribe((data) => {
          this._cookieService.set('usuario', JSON.stringify(data));
          this._router.navigate(['feed']);
        });
    }
  }
}
