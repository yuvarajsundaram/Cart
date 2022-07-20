import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartserviceService } from '../cartservice.service';
import { CustomerDto } from '../CustomerDto';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit, OnChanges {

  @Input()
  customer: any ;

  @Output()
  deleteEvent: EventEmitter<number> = new EventEmitter();

  constructor(private router:Router, private cartService: CartserviceService,
    private route: ActivatedRoute) { }

  ngOnChanges() {
    console.log(this.customer);
    let customer = [];
    customer.length
    this.customer.orders.length
  }

  ngOnInit(): void {
  }

  getLinkName() {
    return this.customer?.orders?.length ? 'view ' + this.customer?.orders?.length +' orders' : 'view orders';
  }

  goToCustomerOrder() {
    this.cartService.sendSelectedCustomer(this.customer);
    this.router.navigate(['/custorder'],
    { queryParams: {customerId : this.customer.customerId }});
  }

  close() {
    this.cartService.deleteCustomersById(this.customer.customerId).subscribe(response => {
      this.deleteEvent.emit(response);
    })
  }

}
