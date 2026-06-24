import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

interface NavItem {
  label: string;
  icon: string;
  route: string;
}

@Component({
  selector: 'app-sidebar',
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './sidebar.html',
  styleUrl: './sidebar.scss'
})
export class Sidebar {
  @Input() collapsed = false;
  @Output() toggleCollapsed = new EventEmitter<void>();

  readonly navItems: NavItem[] = [
    { label: 'Dashboard', icon: 'dashboard', route: '/dashboard' },
    { label: 'Registro de viaje', icon: 'assignment_add', route: '/viajes' },
    { label: 'Mis viajes', icon: 'route', route: '/mis-viajes' },
    { label: 'Revision de fichas', icon: 'fact_check', route: '/revision' },
    { label: 'Historial operativo', icon: 'manage_search', route: '/consultas' },
    { label: 'Cisternas', icon: 'water_damage', route: '/cisternas' },
    { label: 'Usuarios', icon: 'group', route: '/usuarios' }
  ];

  onToggleCollapsed(): void {
    this.toggleCollapsed.emit();
  }
}
