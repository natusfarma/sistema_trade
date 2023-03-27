import { EventEmitter, Injectable } from '@angular/core';
import { Usuario} from '../models/usuario';
import { Permissoes} from '../models/permissoes';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public permissoes:Permissoes = new Permissoes;
  mostrarTarefasEmitter = new EventEmitter<boolean>();
  loginEmitter = new EventEmitter<boolean>();

  constructor(private router:Router) { }

  fazerLogin(usuario:Usuario){

    /*this.permissoes = repositorio.obterPermissoes(usuario)*/ 
    
    switch(this.teste(usuario.nome,usuario.senha)){
      case 1 : {
        this.permissoes.usuario = usuario;
        this.permissoes.permissao = "adm";
        this.mostrarTarefasEmitter.emit(true);
        this.loginEmitter.emit(true);
        break;
      }
      case 2 : {
        this.permissoes.usuario = usuario;
        this.permissoes.permissao = "funcionario";
        this.permissoes.filiais = [1];
        this.mostrarTarefasEmitter.emit(true);
        this.loginEmitter.emit(true);
        break;
      }
      case 3 :{
        this.permissoes.usuario = usuario;
        this.permissoes.permissao = "cliente";
        this.permissoes.filiais = [];
        this.mostrarTarefasEmitter.emit(false);
        this.loginEmitter.emit(true);
        break;
      }
      default:{
        this.mostrarTarefasEmitter.emit(false);
        this.loginEmitter.emit(false);
        return alert("usuario incorreto");
      }
    }
    this.router.navigate(['/'])
  }

  
  obterAcesso(acesso:string){
    if(acesso === this.permissoes.permissao){
      return true;
    }
    return false;
  }




  teste(nome:string,senha:string){
    if(nome === "1" && senha === "s1"){
      return 1;
    }
    if(nome === "2" && senha === "s2"){
      return 2;
    }
    if(nome === "3" && senha === "s3"){
      return 3;
    }
    return 0;

  }


}
