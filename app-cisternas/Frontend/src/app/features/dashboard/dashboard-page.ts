import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { KpiCard } from '../../shared/components/kpi-card/kpi-card';
import { PageHeader } from '../../shared/components/page-header/page-header';
import { StatusBadge } from '../../shared/components/status-badge/status-badge';

interface RecentTrip {
  id: string;
  cisterna: string;
  conductor: string;
  zona: string;
  estado: string;
}

@Component({
  selector: 'app-dashboard-page',
  imports: [KpiCard, PageHeader, RouterLink, StatusBadge],
  templateUrl: './dashboard-page.html',
  styleUrl: './dashboard-page.scss'
})
export class DashboardPage {
  readonly recentTrips: RecentTrip[] = [
    { id: '#V-10254', cisterna: 'CIS-7042', conductor: 'Ricardo Mendoza', zona: 'Zona Norte - P. 14', estado: 'EN_CURSO' },
    { id: '#V-10253', cisterna: 'CIS-5120', conductor: 'Elena Vasquez', zona: 'Centro Industrial', estado: 'APROBADA' },
    { id: '#V-10252', cisterna: 'CIS-8831', conductor: 'Jorge Alva', zona: 'Sector 5 - Almacen', estado: 'PENDIENTE' },
    { id: '#V-10251', cisterna: 'CIS-1290', conductor: 'Sofia Luna', zona: 'Planta Tratamiento', estado: 'OBSERVADA' }
  ];
}
