import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';



@Component({
  selector: 'app-creditos',
  standalone:false,
  templateUrl: './creditos.html',
  styleUrl: './creditos.css',

})
export class Creditos implements OnInit {
  searchByNfse: string = '';
  searchByCredito: string = '';
  creditos: any[] = [];
  ngOnInit():void {
    this.getAllCreditos();
  }
  getAllCreditos(){
    const username = 'dan';
    const password = '123';
    const basicAuth = 'Basic ' + btoa(`${username}:${password}`);
    const endpointCall = "http://localhost:8152/api/creditos"
    fetch(endpointCall,{
        method:'GET',
        headers: {
          'Authorization': basicAuth,
          'X-Requested-With': 'XMLHttpRequest' // 👈 Adiciona esse header
        }
      }
    )
    .then(response=>response.json())
    .then(data=>{
        this.creditos = data;
    
    })
    .catch(error => console.error('Erro ao buscar dados:', error));
  }
  
  onSearchByNfse() {
    this.searchByCredito = ''
    const username = 'dan';
    const password = '123';
    const basicAuth = 'Basic ' + btoa(`${username}:${password}`);
    const endpointCall = "http://localhost:8152/api/creditos/"+this.searchByNfse
    fetch(endpointCall,{
        method:'GET',
        headers: {
          'Authorization': basicAuth,
          'X-Requested-With': 'XMLHttpRequest' // 👈 Adiciona esse header
        }
      }
    )
    .then(response=>response.json())
    .then(data=>{
        this.creditos = data;
    
    })
    .catch(error => console.error('Erro ao buscar dados:', error));

  }
  onSearchByCredito() {
    this.searchByNfse = ''
    const username = 'dan';
    const password = '123';
    const basicAuth = 'Basic ' + btoa(`${username}:${password}`);
    const endpointCall = "http://localhost:8152/api/credito/"+this.searchByCredito
    fetch(endpointCall,{
        method:'GET',
        headers: {
          'Authorization': basicAuth,
          'X-Requested-With': 'XMLHttpRequest' // 👈 Adiciona esse header
        }
      }
    )
    .then(response=>response.json())
    .then(data=>{
        this.creditos = [];
        this.creditos.push(data);
    
    })
    .catch(error => console.error('Erro ao buscar dados:', error));

  }
   
   

}
