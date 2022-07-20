import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngInt';
  isActive = false
  public links = [
    { route: '/customer', label: 'Customers', exact: true  },
    { route: '/order', label: 'Orders', exact:false },
  ];
}
