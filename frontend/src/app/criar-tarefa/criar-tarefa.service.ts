import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Filial } from '../models/filial.model';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CriarTarefaService {

  httpOptions: {} = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };


  constructor(private http: HttpClient) { }
  
  
  obterFiliais() : Observable<Filial[]>{
    
    return this.http.get<Filial[]>("/api/clientes").pipe(
      tap(data =>console.log('All: ' + JSON.stringify(data)))
      );
  };

  criarTarefa(tarefa:FormGroup,url:string){

    let tarefaJson = JSON.stringify(tarefa.value);
    console.log(tarefaJson)
    this.http.post(url,tarefaJson,this.httpOptions).subscribe(
      resultado => {
        console.log(resultado)
      },
      erro => {
        if (erro.status == 400) {
          console.log(erro);
        }
      }
    );

  };

  editarTarefa(){

  };

  cancelarTarefa(){

  };

}
