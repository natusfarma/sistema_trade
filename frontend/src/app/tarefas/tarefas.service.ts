import { Injectable } from '@angular/core';
import { AuthService } from '../login/auth.service';
import { Tarefa } from '../models/tarefa.model';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {
  tarefa : Tarefa = {
    titulo: 'titulo',
    desc: 'deasdsadasdsadsa',
    dataInicio: new Date,
    dataFim: new Date,
    Imagem1: 'imagem1',
    Imagem2: 'imagem2',
    status: 'Concluida',
    mostrar: false
  };
  tarefa2 : Tarefa = {
    titulo: 'titulo2',
    desc: 'deasdsadasdsadsa222',
    dataInicio: new Date,
    dataFim: new Date,
    Imagem1: 'imagem1222222222',
    Imagem2: 'imagem222222222',
    status: 'Andamento',
    mostrar: false
  };
  constructor(public service:AuthService) { }

  obterLista():Tarefa[]{
    /*repository.obterTarefas(service.permissoes.filiais)*/
    if(this.service.permissoes.permissao === "adm"){
      return [this.tarefa,this.tarefa2,this.tarefa,this.tarefa,this.tarefa,this.tarefa,this.tarefa,this.tarefa];
    }
    if(this.service.permissoes.filiais[0] === 1){
      this.idFilial = this.service.permissoes.filiais[0];
      return[this.tarefa];
    }
    
    return [this.tarefa,this.tarefa2];
  }

  idFilial:number = 0;


}
