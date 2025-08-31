import { Routes } from '@angular/router';
import { Login } from '../login/login';

import { CartComponent } from '../cart-component/cart-component';
import { ProductFormComponent } from '../product-form-component/product-form-component';
import { AdminProductsComponent } from '../admin-products-component/admin-products-component';
import { CustomerProductsComponent } from '../customer-products-component/customer-products-component';
import { OrdersComponent } from '../orders-component/orders-component';


export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component:Login  },
    { 
    path: 'admin/products', 
    component: AdminProductsComponent, 
    },
    { 
    path: 'customer/products', 
    component: CustomerProductsComponent 
    },
    { 
    path: 'admin/add-product', 
    component: ProductFormComponent
    },
    { 
    path: 'admin/edit-product/:id', 
    component: ProductFormComponent
    },
    { 
    path: 'carts/add', 
    component: CartComponent 
    },
    { 
    path: 'orders', 
    component: OrdersComponent  
    },
    { path: '**', redirectTo: '/login' }

];
