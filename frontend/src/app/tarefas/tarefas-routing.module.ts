import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmGuard } from '../guards/adm.guard';
import { FuncionarioGuard } from '../guards/funcionario.guard';
import { TarefasGuard } from '../guards/tarefas.guard';
import { TarefasComponent } from './tarefas.component';
const routes: Routes = [
  {   
    path: 'tarefas', component: TarefasComponent,canActivate:[TarefasGuard]
  },
  {
    path:'**',redirectTo:'home'
  }  
];
 
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TarefasRoutingModule { }
