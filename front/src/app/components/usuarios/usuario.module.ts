import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarComponent } from './listar/listar.component';
import { AgregarComponent } from './agregar/agregar.component';
import { RouterModule } from '@angular/router';
import { DataTablesModule } from "angular-datatables";
import { HttpClientModule } from '@angular/common/http';
import { NgbAccordionModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [ListarComponent, AgregarComponent],
  imports: [
    CommonModule,
    RouterModule, // Rutas dinamicas
    DataTablesModule, // Datatables
    HttpClientModule, // Cliente Http
    NgbAccordionModule // Importacion Bootstrap
  ]
})
export class UsuarioModule { }
