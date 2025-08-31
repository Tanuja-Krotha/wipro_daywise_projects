import { Component, OnInit } from '@angular/core';
import { Order, OrderStatus } from '../../interfaces/order';
import { AuthService } from '../../services/auth-service';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { OrderService } from '../../services/order-service';

@Component({
  selector: 'app-orders-component',
  imports: [CurrencyPipe,CommonModule,FormsModule],
  templateUrl: './orders-component.html',
  styleUrl: './orders-component.css'
})
export class OrdersComponent implements OnInit {
  orders: Order[] = [];
  filteredOrders: Order[] = [];
  isLoading = true;
  isAdmin = false;

  statusFilter: string = 'ALL';
  searchTerm: string = '';

  constructor(
    private orderService: OrderService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.isAdmin = this.authService.isAdmin();
    this.loadOrders();
  }

  loadOrders(): void {
    this.isLoading = true;
    
    this.authService.getCurrentUser().subscribe({
      next: (user) => {
        if (this.isAdmin) {
          this.orderService.getAllOrders().subscribe({
            next: (orders) => {
              this.orders = orders;
              this.filteredOrders = orders;
              this.isLoading = false;
            },
            error: (err) => {
              console.error('Error loading orders', err);
              this.isLoading = false;
            }
          });
        } else if (user && user.id) {
          this.orderService.getOrdersByUserId(user.id).subscribe({
            next: (orders) => {
              this.orders = orders;
              this.filteredOrders = orders;
              this.isLoading = false;
            },
            error: (err) => {
              console.error('Error loading orders', err);
              this.isLoading = false;
            }
          });
        }
      },
      error: () => {
        this.isLoading = false;
      }
    });
  }

  cancelOrder(orderId: number): void {
    if (confirm('Are you sure you want to cancel this order?')) {
      this.orderService.cancelOrder(orderId).subscribe({
        next: (updatedOrder) => {
          const index = this.orders.findIndex(order => order.id === orderId);
          if (index !== -1) {
            this.orders[index] = updatedOrder;
            this.filterOrders();
          }
          alert('Order cancelled successfully!');
        },
        error: (err) => {
          console.error('Error cancelling order', err);
          alert('Error cancelling order');
        }
      });
    }
  }

  filterOrders(): void {
    this.filteredOrders = this.orders.filter(order => {
      const statusMatch = this.statusFilter === 'ALL' || order.status === this.statusFilter;
      const searchMatch = !this.searchTerm || 
        order.id.toString().includes(this.searchTerm) ||
        order.items.some(item => 
          item.productName.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      
      return statusMatch && searchMatch;
    });
  }

  getStatusClass(status: OrderStatus): string {
    switch (status) {
      case OrderStatus.CREATED:
        return 'badge bg-primary';
      case OrderStatus.SHIPPED:
        return 'badge bg-info';
      case OrderStatus.DELIVERED:
        return 'badge bg-success';
      case OrderStatus.CANCELLED:
        return 'badge bg-danger';
      default:
        return 'badge bg-warning';
    }
  }

  getStatusText(status: OrderStatus): string {
    return status.charAt(0) + status.slice(1).toLowerCase();
  }

  canCancelOrder(order: Order): boolean {
    return order.status === OrderStatus.PENDING || order.status === OrderStatus.CREATED;
  }



}
