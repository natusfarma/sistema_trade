import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../login/auth.service';
import { Tarefa } from '../models/tarefa.model';
import { TarefasService } from './tarefas.service';

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.css']
})
export class TarefasComponent {

 
  menu:boolean = false;
  perm:string;
  tarefa!:Tarefa;
  filial:number;
  t:Tarefa[];

  constructor(service:AuthService,public serviceT:TarefasService,public authservice:AuthService,public route:Router){
    this.t = serviceT.obterLista();
    this.filial = this.serviceT.idFilial;
    this.perm = service.permissoes.permissao;
  }
 
  abrirMenu(){
    if(this.menu){
      this.menu = false;
    }else{
      this.menu= true;
    }
  }


  filtrarTarefas(/*filtro*/ ){

    //this.t = filtro 

  }
}
