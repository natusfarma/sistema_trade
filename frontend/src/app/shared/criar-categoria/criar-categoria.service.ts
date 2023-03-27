import { HttpClient, HttpHeaders, HttpParamsOptions } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CriarCategoriaService {

  httpOptions: {} = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  
  constructor(private http: HttpClient) {

  }

  obterCategorias() {

  }

  /**
   * {
        categoria: {
          descricao: descricao,
          subCategoria: "teste"
        }
      } */
 
  criarCategoria(FormGroup: FormGroup,url:string) {
    let formJson = JSON.stringify(FormGroup.value);
    console.log(FormGroup.value)
    this.http.post(url, formJson, this.httpOptions)
      .subscribe(
        resultado => {
          console.log(resultado)
        },
        erro => {
          if (erro.status == 400) {
            console.log(erro);
          }
        }
      );
  }

  criarSubCategoria(subCategoria: string) {

  }
} 
