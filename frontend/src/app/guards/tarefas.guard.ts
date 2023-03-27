import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate,Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';

@Injectable({
  providedIn: 'root'
})
export class TarefasGuard implements CanActivate {
  constructor(private service:AuthService,private router:Router){

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    if(this.service.obterAcesso("Deslogado")){
        return this.router.parseUrl("/login");
    }else if(this.service.obterAcesso("adm") || this.service.obterAcesso("funcionario")){
      return true;
    }
    return this.router.parseUrl("/home");
  } 
}
