import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth-service';
import { User } from '../../interfaces/user';
import { CartService } from '../../services/cartservice';


@Component({
  selector: 'app-header',
  imports: [],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header implements OnInit {
    
  currentUser: User | null = null;
  isAdmin = false;
  showDropdown = false;
  cartItemCount = 0;

  constructor(
    public authService: AuthService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.authService.getCurrentUser().subscribe({
      next: (user) => {
        this.currentUser = user;
        this.isAdmin = this.authService.isAdmin();
        
        if (user && user.id) {
          this.loadCartItems(user.id);
        }
      },
      error: () => {
        this.currentUser = null;
        this.isAdmin = false;
      }
    });
  }

  loadCartItems(userId: number): void {
    this.cartService.getCartByUserId(userId).subscribe({
      next: (items) => {
        this.cartItemCount = items.reduce((total, item) => total + item.quantity, 0);
      },
      error: () => {
        this.cartItemCount = 0;
      }
    });
  }

  toggleDropdown(): void {
    this.showDropdown = !this.showDropdown;
  }

  logout(): void {
    this.authService.logout();
    this.showDropdown = false;
    this.cartItemCount = 0;
  }
}
