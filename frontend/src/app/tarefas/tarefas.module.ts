import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TarefasRoutingModule } from './tarefas-routing.module';
import { TarefasComponent } from './tarefas.component';
import { TarefasDetalheComponent } from './tarefas-detalhe/tarefas-detalhe.component';
import { TarefaNovaComponent } from './tarefa-nova/tarefa-nova.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    TarefasComponent,
    TarefasDetalheComponent,
    TarefaNovaComponent,
  ],
  imports: [
    CommonModule,
    TarefasRoutingModule,
    ReactiveFormsModule
  ]
})
export class TarefasModule {

 }
