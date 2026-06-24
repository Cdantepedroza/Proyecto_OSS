import { Routes } from '@angular/router';
import { AppLayout } from './core/layout/app-layout/app-layout';
import { CisternasPage } from './features/cisternas/cisternas-page';
import { ConsultasPage } from './features/consultas/consultas-page';
import { LoginPage } from './features/auth/login-page';
import { DashboardPage } from './features/dashboard/dashboard-page';
import { MisViajesPage } from './features/mis-viajes/mis-viajes-page';
import { RevisionFichasPage } from './features/revision/revision-fichas-page';
import { UsuariosPage } from './features/usuarios/usuarios-page';
import { CierreViajePage } from './features/viajes/cierre-viaje-page';

export const routes: Routes = [
  {
    path: 'login',
    component: LoginPage
  },
  {
    path: '',
    component: AppLayout,
    children: [
      {
        path: '',
        pathMatch: 'full',
        redirectTo: 'dashboard'
      },
      {
        path: 'dashboard',
        component: DashboardPage
      },
      {
        path: 'cisternas',
        component: CisternasPage
      },
      {
        path: 'viajes',
        component: CierreViajePage
      },
      {
        path: 'viajes/cierre',
        component: CierreViajePage
      },
      {
        path: 'mis-viajes',
        component: MisViajesPage
      },
      {
        path: 'revision',
        component: RevisionFichasPage
      },
      {
        path: 'usuarios',
        component: UsuariosPage
      },
      {
        path: 'consultas',
        component: ConsultasPage
      }
    ]
  }
];
