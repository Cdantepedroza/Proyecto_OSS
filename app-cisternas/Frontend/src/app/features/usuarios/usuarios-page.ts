import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PageHeader } from '../../shared/components/page-header/page-header';
import { StatusBadge } from '../../shared/components/status-badge/status-badge';

interface Usuario {
  iniciales: string;
  nombre: string;
  correo: string;
  rol: string;
  estado: string;
  fechaCreacion: string;
}

@Component({
  selector: 'app-usuarios-page',
  imports: [FormsModule, PageHeader, StatusBadge],
  templateUrl: './usuarios-page.html',
  styleUrl: './usuarios-page.scss'
})
export class UsuariosPage {
  readonly usuarios: Usuario[] = [
    { iniciales: 'RM', nombre: 'Roberto Mendoza', correo: 'roberto.m@minaya.pe', rol: 'ADMIN', estado: 'ACTIVO', fechaCreacion: '15/02/2024' },
    { iniciales: 'JS', nombre: 'Juan Soto', correo: 'j.soto@translog.com', rol: 'CONDUCTOR', estado: 'BLOQUEADO', fechaCreacion: '10/01/2024' },
    { iniciales: 'AC', nombre: 'Ana Castillo', correo: 'ana.castillo@minaya.pe', rol: 'LOGISTICA', estado: 'PENDIENTE_ACTIVACION', fechaCreacion: '22/05/2024' },
    { iniciales: 'CL', nombre: 'Carlos Lopez', correo: 'c.lopez@minaya.pe', rol: 'CONDUCTOR', estado: 'ACTIVO', fechaCreacion: '05/03/2024' },
    { iniciales: 'MV', nombre: 'Maria Vargas', correo: 'mvargas@supervisor.com', rol: 'SUPERVISOR', estado: 'ACTIVO', fechaCreacion: '12/12/2023' }
  ];

  mostrarModal = false;
  nuevoUsuario = {
    nombre: '',
    correo: '',
    rol: 'CONDUCTOR',
    sede: 'Principal'
  };

  abrirModal(): void {
    this.mostrarModal = true;
  }

  cerrarModal(): void {
    this.mostrarModal = false;
  }

  crearUsuario(): void {
    this.cerrarModal();
    this.nuevoUsuario = {
      nombre: '',
      correo: '',
      rol: 'CONDUCTOR',
      sede: 'Principal'
    };
  }
}
