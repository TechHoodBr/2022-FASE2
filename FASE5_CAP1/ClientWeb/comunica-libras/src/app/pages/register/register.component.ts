import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Subject, takeUntil } from 'rxjs';
import { Usuario } from 'src/app/model/Usuario';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  usuario: Usuario = new Usuario();
  private _unsubscribeAll: Subject<any> = new Subject<any>();

  constructor(
    private _userService: UserService,
    private _router: Router,
    private _cookieService: CookieService
  ) {}

  ngOnInit() {
    window.scroll(0, 0);
  }

  signUp() {
    this._userService
      .post(this.usuario)
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe((data) => {
        this._cookieService.set('usuario', JSON.stringify(data));
        this._router.navigate(['welcome']);
      });
  }
}
