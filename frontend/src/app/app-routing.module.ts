import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component'
import { HomeComponent } from './home/home.component';
import { PerfilComponent } from './perfil/perfil.component';
import { AuthGuard } from './guards/auth.guard';
import { CriarTarefaComponent } from './criar-tarefa/criar-tarefa.component';
const routes: Routes = [

  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'perfil', component: PerfilComponent,canActivate:[AuthGuard]
  },
  
  {
    path: 'home', component:HomeComponent
  },
  {
    path:'criar',component:CriarTarefaComponent
  }
  ,
  {
    path: '',pathMatch:'full' ,redirectTo:'home'
  }
]



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
