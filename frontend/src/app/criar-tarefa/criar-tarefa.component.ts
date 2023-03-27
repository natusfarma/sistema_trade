import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Filial } from 'src/app/models/filial.model';
import { Categoria } from '../models/categoria.model';
import { teste } from '../models/teste';
import { CriarTarefaService } from './criar-tarefa.service';
@Component({
  selector: 'app-criar-tarefa',
  templateUrl: './criar-tarefa.component.html',
  styleUrls: ['./criar-tarefa.component.css']
})
export class CriarTarefaComponent implements OnInit {

  formulario!: FormGroup;
  mostrarcategoria: boolean = false;
  listaFiliais!: Filial[];
  todosSelect: boolean = false;

  categorias!: Categoria[];

  subecategorias: teste[] = this.popular();



  popular() {
    let list: teste[] = [];
    for (let i = 0; i < 10; i++) {
      let te = new teste("desc" + i, i);
      list.push(te);
    }
    return list;
  }

  constructor(private formBuilder: FormBuilder, private service: CriarTarefaService) {
    service.obterFiliais().subscribe(
      filiais => this.listaFiliais = filiais,
      error => console.log(error)
    );

    //service.obterCategorias()

  }

  ngOnInit() {
    this.formulario = this.formBuilder.group({
      dataTarefa: [null],
      descricao: [null],
      horaLimite: ["23:59"],
      clientes: [],
      subCategoriaId: this.formBuilder.group({
        id: []
      }),
      titulo: [null],
    })
  }

  selecionarTodos() {
    if (this.todosSelect) {
      this.todosSelect = false;
    } else {
      this.todosSelect = true;
    }
    for (let i = 0; i < this.listaFiliais.length; i++) {
      this.listaFiliais[i].checkboxvalue = this.todosSelect;
    }
  }

  mudarCheck(filial: Filial) {
    if (filial.checkboxvalue) {
      filial.checkboxvalue = false;
      this.todosSelect = false;

    } else {
      filial.checkboxvalue = true;

    }
  }

  obterChecks() {
    let list: Filial[] = [];
    for (let i = 0; i < this.listaFiliais.length; i++) {
      const filial = this.listaFiliais[i];
      if (filial.checkboxvalue) {
        list.push(filial);
      }
    }
    return list;
  }


  mostrarCategoria() {
    if (this.mostrarcategoria) {
      this.mostrarcategoria = false;
    } else {
      this.mostrarcategoria = true;
    }
  }

  onSubmit() {
    console.log(this.formulario.value);

    this.formulario.get("clientes")?.setValue(this.obterChecks());

    console.log(this.formulario.value);
    this.service.criarTarefa(this.formulario, "/api/tarefas");
  }

}
