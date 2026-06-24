import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { PageHeader } from '../../shared/components/page-header/page-header';
import { StatusBadge } from '../../shared/components/status-badge/status-badge';

interface ViajeConductor {
  folio: string;
  fecha: string;
  horaInicio: string;
  placa: string;
  zona: string;
  surtidor: string;
  volumen: string;
  estado: string;
  observacion?: string;
}

@Component({
  selector: 'app-mis-viajes-page',
  imports: [PageHeader, RouterLink, StatusBadge],
  templateUrl: './mis-viajes-page.html',
  styleUrl: './mis-viajes-page.scss'
})
export class MisViajesPage {
  readonly viajes: ViajeConductor[] = [
    {
      folio: 'CF-2024-089',
      fecha: '24 Oct, 2023',
      horaInicio: '08:30 AM',
      placa: 'ABC-123',
      zona: 'Sector Norte',
      surtidor: 'Planta Principal',
      volumen: '15.0 m3',
      estado: 'EN_CURSO'
    },
    {
      folio: 'CF-2024-088',
      fecha: '24 Oct, 2023',
      horaInicio: '06:45 AM',
      placa: 'A4V-848',
      zona: 'Chaparral Grande',
      surtidor: 'Las Vegas',
      volumen: '17.8 m3',
      estado: 'PENDIENTE_REVISION'
    },
    {
      folio: 'CF-2024-087',
      fecha: '23 Oct, 2023',
      horaInicio: '03:20 PM',
      placa: 'C7K-219',
      zona: 'San Juan de Miraflores',
      surtidor: 'Pozo San Juan',
      volumen: '10.5 m3',
      estado: 'OBSERVADA',
      observacion: 'Adjuntar foto mas clara del vale firmado por el responsable del punto de entrega.'
    },
    {
      folio: 'CF-2024-086',
      fecha: '23 Oct, 2023',
      horaInicio: '11:10 AM',
      placa: 'L9M-603',
      zona: 'Lurin Industrial',
      surtidor: 'Base Sur',
      volumen: '20.0 m3',
      estado: 'APROBADA'
    },
    {
      folio: 'CF-2024-085',
      fecha: '22 Oct, 2023',
      horaInicio: '09:05 AM',
      placa: 'P2D-775',
      zona: 'Villa Maria del Triunfo',
      surtidor: 'Planta Principal',
      volumen: '14.2 m3',
      estado: 'COMPLETADO'
    }
  ];

  readonly resumen = [
    { label: 'En curso', value: '1', icon: 'local_shipping', color: 'blue' },
    { label: 'Pendientes', value: '1', icon: 'pending_actions', color: 'orange' },
    { label: 'Observadas', value: '1', icon: 'report_problem', color: 'red' },
    { label: 'Aprobadas', value: '2', icon: 'task_alt', color: 'green' }
  ];
}
