import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './home/home.module';
import { AuthService } from './login/auth.service';
import { LoginModule } from './login/login.module';
import { TarefasModule } from './tarefas/tarefas.module';
import { PerfilModule } from './perfil/perfil.module';
import { AuthGuard } from './guards/auth.guard';
import { FuncionarioGuard } from './guards/funcionario.guard';
import { AdmGuard } from './guards/adm.guard';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CriarTarefaModule } from './criar-tarefa/criar-tarefa.module';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    LoginModule,
    HomeModule,
    TarefasModule,
    PerfilModule,
    CriarTarefaModule,
    SharedModule,
    HttpClientModule
  ],
  providers: [AuthService,AuthGuard,FuncionarioGuard,AdmGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
