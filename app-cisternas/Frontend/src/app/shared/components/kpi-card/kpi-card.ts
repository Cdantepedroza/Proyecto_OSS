import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-kpi-card',
  imports: [],
  templateUrl: './kpi-card.html',
  styleUrl: './kpi-card.scss'
})
export class KpiCard {
  @Input({ required: true }) title = '';
  @Input({ required: true }) value = '';
  @Input({ required: true }) icon = '';
  @Input() color: 'blue' | 'orange' | 'green' = 'blue';
  @Input() trend = '';
}
