import { Component, OnInit } from '@angular/core';
import { Tarefa } from 'src/app/models/tarefa.model'; 
import { Input } from '@angular/core';
@Component({
  selector: 'app-tarefas-detalhe',
  templateUrl: './tarefas-detalhe.component.html',
  styleUrls: ['./tarefas-detalhe.component.css']
})
export class TarefasDetalheComponent implements OnInit {

  @Input() t!: Tarefa[];


  constructor(){
   
  }

  obterDetalhes(tarefa:Tarefa){
    if(!tarefa.mostrar){
      tarefa.mostrar = true;
    }else{
      tarefa.mostrar = false;
    }
  }

  ngOnInit() {
    
  }


}
