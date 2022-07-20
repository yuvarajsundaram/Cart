import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer/customer.component';
import { OrderComponent } from './order/order.component';
import { LandingComponent } from './landing/landing.component';
import { CartRoutingModule } from './cart-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CartserviceService } from './cartservice.service';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerOrderComponent } from './customer-order/customer-order.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    CustomerComponent,
    OrderComponent,
    LandingComponent,
    CustomerDetailComponent,
    CustomerOrderComponent
  ],
  imports: [
    CommonModule,
    CartRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CartserviceService]
})
export class CartModule { }
