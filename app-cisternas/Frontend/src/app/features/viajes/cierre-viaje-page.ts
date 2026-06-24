import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PageHeader } from '../../shared/components/page-header/page-header';
import { StatusBadge } from '../../shared/components/status-badge/status-badge';

@Component({
  selector: 'app-cierre-viaje-page',
  imports: [FormsModule, PageHeader, StatusBadge],
  templateUrl: './cierre-viaje-page.html',
  styleUrl: './cierre-viaje-page.scss'
})
export class CierreViajePage {
  readonly viaje = {
    folio: 'CF-2024-089',
    fecha: '24 Oct, 2023',
    conductor: 'Juan Perez',
    ayudante: 'Wilmer Olaya',
    placa: 'ABC-123',
    capacidad: '18 m3',
    zona: 'Sector Norte',
    surtidor: 'Planta Principal',
    puntoDestino: 'Sede comunal Sector Norte',
    lecturaInicial: 15000
  };

  horaInicio = '08:30';
  horaFin = this.obtenerHoraActual();
  tipoLiquido = 'Agua potable';
  valeCarga = 'VC-2024-1128';
  lecturaFinal: number | null = null;
  cloroResidual: number | null = null;
  observaciones = '';
  estadoFormulario = 'EN_CURSO';

  constructor(private readonly router: Router) {}

  get volumenDistribuido(): number {
    if (this.lecturaFinal === null) {
      return 0;
    }

    return this.lecturaFinal - this.viaje.lecturaInicial;
  }

  get volumenTexto(): string {
    if (this.volumenDistribuido < 0) {
      return 'Lectura menor a la inicial';
    }

    return `${this.volumenDistribuido.toLocaleString('es-PE')} Lts`;
  }

  finalizarViaje(): void {
    if (this.volumenDistribuido <= 0 || this.cloroResidual === null || !this.horaInicio || !this.horaFin) {
      return;
    }

    this.estadoFormulario = 'PENDIENTE_REVISION';

    window.setTimeout(() => {
      this.router.navigate(['/mis-viajes']);
    }, 900);
  }

  cancelar(): void {
    this.lecturaFinal = null;
    this.cloroResidual = null;
    this.observaciones = '';
    this.estadoFormulario = 'EN_CURSO';
    this.router.navigate(['/mis-viajes']);
  }

  private obtenerHoraActual(): string {
    const ahora = new Date();
    return ahora.toTimeString().slice(0, 5);
  }
}
