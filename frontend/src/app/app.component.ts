import { Component, OnInit } from '@angular/core';
import { AuthService } from './login/auth.service';
import { Permissoes } from './models/permissoes';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'projeto';

  public permissoes:Permissoes = new Permissoes();
  logado:boolean = true;
  mostrarTarefas:boolean = true;

  constructor(private authService:AuthService){
    
  }
  ngOnInit(){
    this.authService.mostrarTarefasEmitter.subscribe(
      mostrar => this.mostrarTarefas = mostrar
    );

    this.authService.loginEmitter.subscribe(
      log => this.logado = log
    );
  }

}
