import { Component } from '@angular/core';


@Component({
  selector: 'app-creditos',
  standalone:false,
  templateUrl: './creditos.html',
  styleUrl: './creditos.css',

})
export class Creditos {
  searchTerm: string = '';
  onSearch() {
    const username = 'dan';
    const password = '123';
    const basicAuth = 'Basic ' + btoa(`${username}:${password}`);
    const endpointCall = "http://localhost:8152/api/creditos/"+this.searchTerm
    fetch(endpointCall,{
        method:'GET',
        headers: {
          'Authorization': basicAuth
        }
      }
    )
    .then(response=>response.json())
    .then(data=>console.log(data))
    .catch(error => console.error('Erro ao buscar dados:', error));

    console.log('Buscando por:', this.searchTerm);
  }
   creditos = [
    {
      numeroCredito: "CR10001",
      nfse: "NF001",
      dataConstituicao: "2024-01-01",
      valorIssqn: 1200.00,
      tipoCredito: "Normal",
      simplesNacional: false,
      aliquota: 5.00,
      valorFaturado: 18000.00,
      valorDeducao: 300.00,
      baseCalculo: 17700.00
    },
    {
      numeroCredito: "CR10002",
      nfse: "NF001",
      dataConstituicao: "2024-01-02",
      valorIssqn: 1300.00,
      tipoCredito: "Normal",
      simplesNacional: false,
      aliquota: 5.00,
      valorFaturado: 18500.00,
      valorDeducao: 400.00,
      baseCalculo: 18100.00
    },
    {
      numeroCredito: "CR10003",
      nfse: "NF001",
      dataConstituicao: "2024-01-03",
      valorIssqn: 1250.00,
      tipoCredito: "Normal",
      simplesNacional: false,
      aliquota: 5.00,
      valorFaturado: 19000.00,
      valorDeducao: 500.00,
      baseCalculo: 18500.00
    }
  ];

}
