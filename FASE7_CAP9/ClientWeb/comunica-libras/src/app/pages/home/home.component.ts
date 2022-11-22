import { Component } from '@angular/core';
import { Usuario } from 'src/app/model/Usuario';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  usuario: Usuario;

  constructor() {}
}
