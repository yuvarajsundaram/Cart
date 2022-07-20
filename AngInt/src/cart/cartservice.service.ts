import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { CustomerDto } from './CustomerDto';

@Injectable({
  providedIn: 'root'
})
export class CartserviceService {

  private customerOrder: any = new Subject();
  public $customerOrder = this.customerOrder.asObservable();

  constructor(private http: HttpClient) { }

  getCustomers():Observable<any> {
    return this.http.get("http://localhost:8080/customer");
  }

  getCustomersById(value:number):Observable<any> {
    return this.http.get("http://localhost:8080/customer/"+value);
  }

  saveCustomer(data: any):Observable<any>  {
    return this.http.post("http://localhost:8080/customer/", data);
  }

  deleteCustomersById(value:number):Observable<any> {
    return this.http.delete("http://localhost:8080/customer/"+value);
  }

  sendSelectedCustomer(customers: any) {
    this.customerOrder.next(customers);
  }

  getSelected() {
    return this.customerOrder.asObservable();
  }
}
