import { Injectable, signal } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CartItem, CartItemDTO } from '../interfaces/cartitem';

@Injectable({
  providedIn: 'root'
})
export class CartService {
 private apiUrl = 'http://localhost:8083/carts';
  private cartItems = signal<CartItem[]>([]);

  constructor(private http: HttpClient) {}

  // Fixed addToCart method
  addToCart(cartItemDTO: CartItemDTO): Observable<CartItem> {
    return this.http.post<CartItem>(`${this.apiUrl}/add`, cartItemDTO).pipe(
      tap(newItem => {
        const currentItems = this.cartItems();
        const existingItemIndex = currentItems.findIndex(item => 
          item.productId === newItem.productId && item.userId === newItem.userId
        );
        
        if (existingItemIndex > -1) {
          // Update quantity if item already exists
          const updatedItems = [...currentItems];
          updatedItems[existingItemIndex] = newItem;
          this.cartItems.set(updatedItems);
        } else {
          // Add new item
          this.cartItems.set([...currentItems, newItem]);
        }
      })
    );
  }

  // Make sure all other methods are properly implemented
  removeFromCart(cartItemId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${cartItemId}`).pipe(
      tap(() => {
        const updatedItems = this.cartItems().filter(item => item.id !== cartItemId);
        this.cartItems.set(updatedItems);
      })
    );
  }

  updateCartItemQuantity(cartItemId: number, quantity: number): Observable<CartItem> {
    // Note: Your backend expects quantity as a query parameter, not in body
    return this.http.put<CartItem>(`${this.apiUrl}/${cartItemId}?quantity=${quantity}`, {}).pipe(
      tap(updatedItem => {
        const currentItems = this.cartItems();
        const updatedItems = currentItems.map(item => 
          item.id === cartItemId ? updatedItem : item
        );
        this.cartItems.set(updatedItems);
      })
    );
  }

  getCartByUserId(userId: number): Observable<CartItem[]> {
    return this.http.get<CartItem[]>(`${this.apiUrl}/user/${userId}`);
  }

  clearCart(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/user/${userId}`).pipe(
      tap(() => this.cartItems.set([]))
    );
  }

  getCartItems() {
    return this.cartItems.asReadonly();
  }

  getItemCount(): number {
    return this.cartItems().reduce((total, item) => total + item.quantity, 0);
  }

  getTotal(): number {
    return this.cartItems().reduce((total, item) => total + (item.price * item.quantity), 0);
  }
}
