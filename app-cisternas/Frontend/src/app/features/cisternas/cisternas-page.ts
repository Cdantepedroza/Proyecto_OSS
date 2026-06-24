import { Component } from '@angular/core';
import { PageHeader } from '../../shared/components/page-header/page-header';
import { StatusBadge } from '../../shared/components/status-badge/status-badge';

interface Cisterna {
  placa: string;
  capacidad: string;
  estado: string;
  disponible: boolean;
}

@Component({
  selector: 'app-cisternas-page',
  imports: [PageHeader, StatusBadge],
  templateUrl: './cisternas-page.html',
  styleUrl: './cisternas-page.scss'
})
export class CisternasPage {
  readonly cisternas: Cisterna[] = [
    { placa: 'ABC-123', capacidad: '5000 gal', estado: 'ACTIVO', disponible: true },
    { placa: 'XYZ-789', capacidad: '8000 gal', estado: 'MANTENIMIENTO', disponible: false },
    { placa: 'DEF-456', capacidad: '5000 gal', estado: 'FUERA_SERVICIO', disponible: false },
    { placa: 'GHI-012', capacidad: '10000 gal', estado: 'ACTIVO', disponible: true }
  ];
}
