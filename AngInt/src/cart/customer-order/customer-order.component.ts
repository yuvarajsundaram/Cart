import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { CartserviceService } from '../cartservice.service';
import { CustomerDto } from '../CustomerDto';

@Component({
  selector: 'app-customer-order',
  templateUrl: './customer-order.component.html',
  styleUrls: ['./customer-order.component.css']
})
export class CustomerOrderComponent implements OnInit {

  customerId: any;
  customers: CustomerDto[] = [];
  
  @Input()
  allOrders = false;
  constructor(private cartService: CartserviceService, private route: ActivatedRoute) { }
  

  ngOnInit() {
    
    this.route.queryParams.subscribe(value => this.customerId = value['customerId']);
    if(this.customerId) {
      this.cartService.getCustomersById(this.customerId).subscribe(Response => {
        this.customers.push(Response);
      })
    } else if(this.allOrders) {
      this.cartService.getCustomers().subscribe(response => {
        this.customers = response
      })
    }
       
  }

  getCustomerDto() {
    return this.customers;
  }

  getTotal(index: number) {
    return this.customers[index]?.orders?.length ? this.customers[index]?.orders.map(o => o.totalPrice).reduce((a,b) => a+b) : '';
  }

  getTitle() {
    return this.allOrders ? 'All Customer Orders' : 'Customer Orders';
  }

}
