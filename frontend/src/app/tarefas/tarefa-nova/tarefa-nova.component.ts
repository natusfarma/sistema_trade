import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-tarefa-nova',
  templateUrl: './tarefa-nova.component.html',
  styleUrls: ['./tarefa-nova.component.css']
})
export class TarefaNovaComponent implements OnInit{

  formulario!:FormGroup;
  
  constructor(private formBuilder:FormBuilder){

  }

  ngOnInit(): void {
    this.formulario = this.formBuilder.group({
      titulo:[null],
      desc:[null]
    })
   
  }

}
