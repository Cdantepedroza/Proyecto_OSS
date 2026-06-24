import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Sidebar } from '../sidebar/sidebar';
import { Topbar } from '../topbar/topbar';

@Component({
  selector: 'app-layout',
  imports: [Sidebar, Topbar, RouterOutlet],
  templateUrl: './app-layout.html',
  styleUrl: './app-layout.scss'
})
export class AppLayout {
  sidebarCollapsed = false;

  toggleSidebar(): void {
    this.sidebarCollapsed = !this.sidebarCollapsed;
  }
}
