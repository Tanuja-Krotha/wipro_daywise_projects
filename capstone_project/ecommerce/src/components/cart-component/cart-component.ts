import { Component, OnInit } from '@angular/core';
import { CartService,} from '../../services/cartservice';
import { CartItem } from '../../interfaces/cartitem';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { AuthService } from '../../services/auth-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart-component',
  imports: [CurrencyPipe,CommonModule],
  templateUrl: './cart-component.html',
  styleUrl: './cart-component.css'
})
export class CartComponent implements OnInit{
  cartItems: CartItem[] = [];
  isLoading = true;

  constructor(
    private cartService: CartService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadCartItems();
  }

  loadCartItems(): void {
    this.authService.getCurrentUser().subscribe({
      next: (user) => {
        if (user && user.id) {
          this.cartService.getCartByUserId(user.id).subscribe({
            next: (items) => {
              this.cartItems = items;
              this.isLoading = false;
            },
            error: (err) => {
              console.error('Error loading cart items', err);
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

  incrementQuantity(item: CartItem): void {
    if (item.id) {
      this.cartService.updateCartItemQuantity(item.id, item.quantity + 1).subscribe({
        next: (updatedItem) => {
          const index = this.cartItems.findIndex(i => i.id === item.id);
          if (index !== -1) {
            this.cartItems[index] = updatedItem;
          }
        },
        error: (err) => {
          console.error('Error updating quantity', err);
        }
      });
    }
  }

  decrementQuantity(item: CartItem): void {
    if (item.id && item.quantity > 1) {
      this.cartService.updateCartItemQuantity(item.id, item.quantity - 1).subscribe({
        next: (updatedItem) => {
          const index = this.cartItems.findIndex(i => i.id === item.id);
          if (index !== -1) {
            this.cartItems[index] = updatedItem;
          }
        },
        error: (err) => {
          console.error('Error updating quantity', err);
        }
      });
    }
  }

  removeFromCart(itemId: number): void {
    this.cartService.removeFromCart(itemId).subscribe({
      next: () => {
        this.cartItems = this.cartItems.filter(item => item.id !== itemId);
      },
      error: (err) => {
        console.error('Error removing item from cart', err);
      }
    });
  }

  getTotal(): number {
    return this.cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);
  }

  checkout(): void {
    this.authService.getCurrentUser().subscribe({
      next: (user) => {
        if (user && user.id) {
          // In a real application, you would call an order service here
          alert('Checkout functionality would be implemented here!');
          
          // Clear cart after successful checkout
          this.cartService.clearCart(user.id).subscribe({
            next: () => {
              this.cartItems = [];
              alert('Order placed successfully!');
              this.router.navigate(['/orders']);
            },
            error: (err) => {
              console.error('Error during checkout', err);
              alert('Error during checkout');
            }
          });
        }
      },
      error: () => {
        alert('Please login to checkout');
      }
    });
  }
  

  updateQuantity(item: CartItem, quantity: number): void {
    if (quantity <= 0) {
      this.removeFromCart(item.id!);
    } else if (item.id) {
      this.cartService.updateCartItemQuantity(item.id, quantity).subscribe({
        next: (updatedItem) => {
          const index = this.cartItems.findIndex(i => i.id === item.id);
          if (index !== -1) {
            this.cartItems[index] = updatedItem;
          }
        },
        error: (err) => {
          console.error('Error updating quantity', err);
          alert('Error updating quantity');
        }
      });
    }
  }

  

}
