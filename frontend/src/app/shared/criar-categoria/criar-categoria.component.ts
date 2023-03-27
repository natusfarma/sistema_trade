import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CriarCategoriaService } from './criar-categoria.service';

@Component({
  selector: 'app-criar-categoria',
  templateUrl: './criar-categoria.component.html',
  styleUrls: ['./criar-categoria.component.css']
})
export class CriarCategoriaComponent implements OnInit {

  @Input() mostrarCategoria!: boolean;

  cForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private service: CriarCategoriaService) {

  }
  ngOnInit() {

    this.cForm = this.formBuilder.group({
      categoria: this.formBuilder.group({
        descricao: [null]
      }),
      descricao: [null]
    })
  }

  criarCategoria() {
    this.service.criarCategoria(this.cForm, '/api/subcategorias/adds');   
  }
}
