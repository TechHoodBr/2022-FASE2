import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Usuario } from 'src/app/model/Usuario';

@Component({
  selector: 'app-menu-feed',
  templateUrl: './menu-feed.component.html',
  styleUrls: ['./menu-feed.component.css'],
})
export class MenuFeedComponent implements OnInit {
  @Input() usuario: Usuario;

  constructor(private _cookieService: CookieService, private _router: Router) {}

  ngOnInit(): void {
    if (this._cookieService.get('usuario')) {
      this.usuario = JSON.parse(this._cookieService.get('usuario'));
    } else {
      this._router.navigate(['login']);
    }
  }

  logout() {
    this.usuario = null;
    this._cookieService.deleteAll();
    this._router.navigate(['login']);
  }
}
