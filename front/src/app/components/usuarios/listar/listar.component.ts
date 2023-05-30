import { AfterViewInit, Component, OnDestroy, OnInit, ViewChild, Renderer } from '@angular/core';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import { Usuario } from 'src/app/models/usuario.model';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss']
})
export class ListarComponent implements OnInit, AfterViewInit, OnDestroy {
  usuarios?: Usuario[];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  @ViewChild(DataTableDirective, { static: false })
  dtElement: DataTableDirective;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private renderer: Renderer
  ) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      columns: [{
        title: 'ID',
        data: 'ccrUsuario'
      }, {
        title: 'Nombre',
        data: 'glsUsername'
      }, {
        title: 'Action',
        render: (data: any, type: any, full: any) => {
          return 'View';
        }
      }],
      rowCallback: (row: Node, data: any[], index: number) => {
        $('td', row).unbind('click');
        $('td', row).bind('click', () => {
          this.redireccionarEditar(data); // Redireccionar al hacer clic en la fila
        });
        return row;
      }
    };
  }

  ngAfterViewInit(): void {
    this.listarTodos();
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  listarTodos() {
    this.usuarioService.listar().subscribe(
      usuarios => {
        this.usuarios = usuarios;
        /* Asignamos los registros a la data de datatables */
        this.dtOptions.data = usuarios;
        /* Refrescamos datatables */
        this.dtTrigger.next();
      },
      error => {
        console.log('Error al obtener usuarios:', error);
      }
    );
  }

  rerender(): void {
    /* El presente metodo sirve para volver a renderizar datatables */
    this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      dtInstance.destroy();
      this.dtTrigger.next();
    });
  }

  redireccionarEditar(data: any): void {
    this.router.navigate(['/usuarios/agregar'], { state: { usuario: data as Usuario } });
  }
}
