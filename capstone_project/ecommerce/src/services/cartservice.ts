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

  addToCart(cartItemDTO: CartItemDTO): Observable<CartItem> {
    return this.http.post<CartItem>('http://localhost:8083/carts/add', cartItemDTO).pipe(
      tap(newItem => {
        const currentItems = this.cartItems();
        const existingItemIndex = currentItems.findIndex(item => 
          item.productId === newItem.productId
        );
        
        if (existingItemIndex > -1) {
          currentItems[existingItemIndex].quantity += newItem.quantity;
        } else {
          currentItems.push(newItem);
        }
        
        this.cartItems.set([...currentItems]);
      })
    );
  }

  removeFromCart(cartItemId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${cartItemId}`).pipe(
      tap(() => {
        const currentItems = this.cartItems();
        const updatedItems = currentItems.filter(item => item.id !== cartItemId);
        this.cartItems.set(updatedItems);
      })
    );
  }

  updateCartItemQuantity(cartItemId: number, quantity: number): Observable<CartItem> {
    return this.http.put<CartItem>(`${this.apiUrl}/${cartItemId}`, { quantity }).pipe(
      tap(updatedItem => {
        const currentItems = this.cartItems();
        const itemIndex = currentItems.findIndex(item => item.id === cartItemId);
        
        if (itemIndex > -1) {
          currentItems[itemIndex] = updatedItem;
          this.cartItems.set([...currentItems]);
        }
      })
    );
  }

  getCartByUserId(userId: number): Observable<CartItem[]> {
    return this.http.get<CartItem[]>(`${this.apiUrl}/user/${userId}`).pipe(
      tap(items => this.cartItems.set(items))
    );
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
