import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PageHeader } from '../../shared/components/page-header/page-header';
import { StatusBadge } from '../../shared/components/status-badge/status-badge';

interface FichaPendiente {
  id: string;
  fecha: string;
  hora: string;
  vehiculo: string;
  conductor: string;
  zona: string;
  volumen: string;
  surtidor: string;
  ayudante: string;
  contratista: string;
  puntoEntrega: string;
  coordenadas: string;
  tiempoRuta: string;
  lecturaInicial: string;
  lecturaFinal: string;
  cloroResidual: string;
  observaciones: string;
}

@Component({
  selector: 'app-revision-fichas-page',
  imports: [FormsModule, PageHeader, StatusBadge],
  templateUrl: './revision-fichas-page.html',
  styleUrl: './revision-fichas-page.scss'
})
export class RevisionFichasPage {
  readonly fichas: FichaPendiente[] = [
    {
      id: 'F-2024-001',
      fecha: '24 Oct, 2023',
      hora: '08:45 AM',
      vehiculo: 'V9A-882',
      conductor: 'Carlos Mendoza',
      zona: 'Villa El Salvador',
      volumen: '15.5 m3',
      surtidor: 'Planta Principal',
      ayudante: 'Wilmer Olaya',
      contratista: 'Transportes Minaya Heredia',
      puntoEntrega: 'Sede Comunal Sector 4',
      coordenadas: '-12.2144, -76.9388',
      tiempoRuta: '1h 15min',
      lecturaInicial: '90,059.10',
      lecturaFinal: '90,074.60',
      cloroResidual: '1.19 mg/L',
      observaciones: 'Se presento trafico pesado en Av. Pachacutec. Entrega conforme sin incidentes.'
    },
    {
      id: 'F-2024-002',
      fecha: '24 Oct, 2023',
      hora: '10:12 AM',
      vehiculo: 'B3X-451',
      conductor: 'Jorge Luis Paez',
      zona: 'Chorrillos - Sector 3',
      volumen: '12.0 m3',
      surtidor: 'Base Sur',
      ayudante: 'Luis Rojas',
      contratista: 'AquaTrans Peru',
      puntoEntrega: 'Reservorio auxiliar Chorrillos',
      coordenadas: '-12.1722, -77.0164',
      tiempoRuta: '58min',
      lecturaInicial: '52,840.00',
      lecturaFinal: '52,852.00',
      cloroResidual: '1.08 mg/L',
      observaciones: 'Entrega realizada dentro del horario programado.'
    },
    {
      id: 'F-2024-003',
      fecha: '24 Oct, 2023',
      hora: '11:30 AM',
      vehiculo: 'V1P-772',
      conductor: 'Raul Ramirez',
      zona: 'Ate Vitarte',
      volumen: '18.0 m3',
      surtidor: 'Estacion Norte',
      ayudante: 'Pedro Ramos',
      contratista: 'Servicios Hidricos Lima',
      puntoEntrega: 'Comite vecinal Ate',
      coordenadas: '-12.0432, -76.9287',
      tiempoRuta: '1h 32min',
      lecturaInicial: '71,210.40',
      lecturaFinal: '71,228.40',
      cloroResidual: '1.24 mg/L',
      observaciones: 'Se entrego el volumen total solicitado por coordinacion.'
    },
    {
      id: 'F-2024-004',
      fecha: '24 Oct, 2023',
      hora: '12:05 PM',
      vehiculo: 'A4V-848',
      conductor: 'Franks Montes',
      zona: 'Chaparral Grande',
      volumen: '17.8 m3',
      surtidor: 'Las Vegas',
      ayudante: 'Wilmer Olaya',
      contratista: 'Transportes y Servicios Minaya Heredia',
      puntoEntrega: 'Asociacion Chaparral Grande',
      coordenadas: '-12.0913, -76.9814',
      tiempoRuta: '1h 06min',
      lecturaInicial: '91,409.12',
      lecturaFinal: '91,426.92',
      cloroResidual: '1.39 mg/L',
      observaciones: 'La entrega fue conforme. Se registro firma del encargado en el vale fisico.'
    },
    {
      id: 'F-2024-005',
      fecha: '24 Oct, 2023',
      hora: '01:20 PM',
      vehiculo: 'C7K-219',
      conductor: 'Sofia Luna',
      zona: 'San Juan de Miraflores',
      volumen: '10.5 m3',
      surtidor: 'Pozo San Juan',
      ayudante: 'Elmer Castillo',
      contratista: 'Consorcio Sur Agua',
      puntoEntrega: 'Modulo comunal Pamplona Alta',
      coordenadas: '-12.1630, -76.9701',
      tiempoRuta: '49min',
      lecturaInicial: '33,100.00',
      lecturaFinal: '33,110.50',
      cloroResidual: '0.98 mg/L',
      observaciones: 'Entrega parcial por capacidad limitada del punto receptor.'
    },
    {
      id: 'F-2024-006',
      fecha: '24 Oct, 2023',
      hora: '02:10 PM',
      vehiculo: 'L9M-603',
      conductor: 'Miguel Torres',
      zona: 'Lurin Industrial',
      volumen: '20.0 m3',
      surtidor: 'Base Sur',
      ayudante: 'Henry Salazar',
      contratista: 'Logistica H2O SAC',
      puntoEntrega: 'Planta auxiliar Lurin',
      coordenadas: '-12.2765, -76.8662',
      tiempoRuta: '1h 48min',
      lecturaInicial: '104,220.00',
      lecturaFinal: '104,240.00',
      cloroResidual: '1.31 mg/L',
      observaciones: 'Se reporto demora por control de ingreso, sin afectar el volumen final entregado.'
    },
    {
      id: 'F-2024-007',
      fecha: '24 Oct, 2023',
      hora: '03:25 PM',
      vehiculo: 'P2D-775',
      conductor: 'Elena Vasquez',
      zona: 'Villa Maria del Triunfo',
      volumen: '14.2 m3',
      surtidor: 'Planta Principal',
      ayudante: 'Marco Leon',
      contratista: 'Ruta Azul Transporte',
      puntoEntrega: 'Agrupacion Virgen del Carmen',
      coordenadas: '-12.1768, -76.9340',
      tiempoRuta: '1h 11min',
      lecturaInicial: '67,802.80',
      lecturaFinal: '67,817.00',
      cloroResidual: '1.12 mg/L',
      observaciones: 'Entrega conforme con presencia del supervisor zonal.'
    }
  ];

  fichaSeleccionada: FichaPendiente | null = null;
  mostrarModal = false;
  motivoObservacion = 'Imagen del odometro ilegible';
  detalleObservacion = '';
  toastMensaje = '';
  toastIcono = 'check_circle';

  seleccionarFicha(ficha: FichaPendiente): void {
    this.fichaSeleccionada = ficha;
  }

  cerrarDetalle(): void {
    this.fichaSeleccionada = null;
  }

  abrirObservacion(): void {
    this.mostrarModal = true;
  }

  cerrarObservacion(): void {
    this.mostrarModal = false;
  }

  aprobarFicha(): void {
    this.mostrarToast('Ficha aprobada y registrada exitosamente', 'check_circle');
    this.cerrarDetalle();
  }

  enviarObservacion(): void {
    this.mostrarToast('La observacion ha sido enviada al conductor', 'report_problem');
    this.cerrarObservacion();
    this.cerrarDetalle();
    this.detalleObservacion = '';
  }

  private mostrarToast(mensaje: string, icono: string): void {
    this.toastMensaje = mensaje;
    this.toastIcono = icono;

    window.setTimeout(() => {
      this.toastMensaje = '';
    }, 3000);
  }
}
