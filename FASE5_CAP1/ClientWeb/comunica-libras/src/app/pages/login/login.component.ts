import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/Usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  usuario: Usuario = new Usuario();
  ngOnInit(): void {
    window.scroll(0, 0);
  }

  signIn(){}

}
