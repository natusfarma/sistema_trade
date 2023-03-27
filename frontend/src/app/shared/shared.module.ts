import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CriarCategoriaComponent } from './criar-categoria/criar-categoria.component';
import { SelecionarFiliaisComponent } from './selecionar-filiais/selecionar-filiais.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    CriarCategoriaComponent,
    SelecionarFiliaisComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    CriarCategoriaComponent,
    SelecionarFiliaisComponent
  ]
})
export class SharedModule { }
