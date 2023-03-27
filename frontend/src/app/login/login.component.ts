import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../models/usuario';
import { AuthService } from './auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public usuario: Usuario = new Usuario();

  constructor(private authservice:AuthService,private route:Router){

  }
  ngOnInit(){
    
  }

  fazerLogin(){
    this.authservice.fazerLogin(this.usuario);
    
  }
}
