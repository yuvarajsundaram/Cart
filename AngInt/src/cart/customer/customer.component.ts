import { Component, OnInit } from '@angular/core';
import { CartserviceService } from '../cartservice.service';
import { CustomerDto } from '../CustomerDto';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private cartService: CartserviceService) { }

  datas : CustomerDto[] = [];

  newCustomer: CustomerDto = {
    customerId : 0,
    firstName :  '',
    lastName : '',
    city : '',
    orders : []
  };

  ngOnInit(): void {
    this.cartService.getCustomers().subscribe( response => {
      this.datas = response;
      console.log(this.datas);
    })
  }

  addCustomer() {
    this.cartService.saveCustomer(this.newCustomer).subscribe(response => {
      this.datas.push(response);
      this.newCustomer = {
        customerId : 0,
        firstName :  '',
        lastName : '',
        city : '',
        orders : []
      };
    })
  }

  deleteCustomer(deletedCustId: number) {
    this.datas = this.datas.filter(data => data.customerId != deletedCustId);
  }

}
