import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-status-badge',
  imports: [],
  templateUrl: './status-badge.html',
  styleUrl: './status-badge.scss'
})
export class StatusBadge {
  @Input({ required: true }) status = '';

  get statusClass(): string {
    return this.status.toLowerCase().replace(/_/g, '-');
  }
}
