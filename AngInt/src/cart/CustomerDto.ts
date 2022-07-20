import { OrderDto } from "./OrderDto";

export interface CustomerDto {
    
    customerId : number,
    firstName :  string;
    lastName : string;
    city : string;
    orders : OrderDto[];

}