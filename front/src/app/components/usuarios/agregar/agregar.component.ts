import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';


@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.scss']
})
export class AgregarComponent implements OnInit {
  usuarioEditar?: Usuario;
  constructor() {

  }
  ngOnInit(): void {
    this.usuarioEditar = history.state.usuario; /* Recepcionamos los datos del usuario en caso de editar */
    console.log(history);
    if (typeof this.usuarioEditar !== 'undefined') {/* Si se encuentra la causa con datos */
      console.log(this.usuarioEditar);
      // Limpiar los valores en el historial de navegación
      history.replaceState({ ...history.state, usuario: null }, '');
    } else {
      //this.titulo = 'Agregar Causa';/* En caso contrario es agregar */
    }
  }
}
