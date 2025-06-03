import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Adicione esta importação


@Component({
  selector: 'app-creditos',
  standalone:true,
  imports: [CommonModule],
  templateUrl: './creditos.html',
  styleUrl: './creditos.css',

})
export class Creditos {

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
