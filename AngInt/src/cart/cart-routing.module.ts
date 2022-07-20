import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CustomerOrderComponent } from "./customer-order/customer-order.component";
import { CustomerComponent } from "./customer/customer.component";
import { LandingComponent } from "./landing/landing.component";
import { OrderComponent } from "./order/order.component";

const routes: Routes = [
    {
      path: 'customer',
      component: CustomerComponent
    },
    {
        path: 'order',
        component: OrderComponent
      },
      {
        path: '',
        redirectTo: 'customer',
        pathMatch: "full"
      },{
        path: 'custorder',
        component : CustomerOrderComponent
      }
  ];

  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class CartRoutingModule { }