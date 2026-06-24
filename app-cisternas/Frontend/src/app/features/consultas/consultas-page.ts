import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { PageHeader } from '../../shared/components/page-header/page-header';
import { StatusBadge } from '../../shared/components/status-badge/status-badge';

interface ViajeHistorial {
  id: string;
  fechaHora: string;
  placa: string;
  conductor: string;
  volumen: string;
  surtidor: string;
  estado: string;
}

@Component({
  selector: 'app-consultas-page',
  imports: [PageHeader, RouterLink, StatusBadge],
  templateUrl: './consultas-page.html',
  styleUrl: './consultas-page.scss'
})
export class ConsultasPage {
  readonly viajes: ViajeHistorial[] = [
    { id: '#VJ-2024-001', fechaHora: '24 Oct 2023, 08:30 AM', placa: 'BQX-982', conductor: 'Carlos Rodriguez', volumen: '15.5', surtidor: 'Estacion Central', estado: 'COMPLETADO' },
    { id: '#VJ-2024-002', fechaHora: '24 Oct 2023, 09:15 AM', placa: 'MNH-451', conductor: 'Juan Perez', volumen: '12.0', surtidor: 'Pozo San Juan', estado: 'EN_PROGRESO' },
    { id: '#VJ-2024-003', fechaHora: '24 Oct 2023, 10:45 AM', placa: 'PKZ-223', conductor: 'Maria Lopez', volumen: '18.2', surtidor: 'Estacion Norte', estado: 'PENDIENTE' },
    { id: '#VJ-2024-004', fechaHora: '23 Oct 2023, 15:20 PM', placa: 'BQX-982', conductor: 'Carlos Rodriguez', volumen: '15.5', surtidor: 'Estacion Central', estado: 'COMPLETADO' },
    { id: '#VJ-2024-005', fechaHora: '23 Oct 2023, 11:00 AM', placa: 'LLP-109', conductor: 'Mateo Garcia', volumen: '10.0', surtidor: 'Surtidor Oeste', estado: 'CANCELADO' }
  ];
}
