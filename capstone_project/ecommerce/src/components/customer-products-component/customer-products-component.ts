import { Component, OnInit } from '@angular/core';
import { Product } from '../../interfaces/product';
import { ProductService } from '../../services/productservice';
import { CartService } from '../../services/cartservice';
import { AuthService } from '../../services/auth-service';
import { CommonModule, CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-customer-products-component',
  imports: [CurrencyPipe,CommonModule],
  templateUrl: './customer-products-component.html',
  styleUrl: './customer-products-component.css'
})
export class CustomerProductsComponent implements OnInit {
products: Product[] = [];
  filteredProducts: Product[] = [];
  searchTerm: string = '';

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getAllProducts().subscribe({
      next: (products) => {
        this.products = products;
        this.filteredProducts = products;
      },
      error: (err) => {
        console.error('Error loading products', err);
      }
    });
  }

  filterProducts(): void {
    if (!this.searchTerm) {
      this.filteredProducts = this.products;
      return;
    }

    const term = this.searchTerm.toLowerCase();
    this.filteredProducts = this.products.filter(product =>
      product.name.toLowerCase().includes(term) ||
      product.description.toLowerCase().includes(term)
    );
  }
  handleImageError(event: Event): void {
    const imgElement = event.target as HTMLImageElement;
    imgElement.style.display = 'none';
    
    // Find the parent container and show a placeholder
    const container = imgElement.closest('.product-image-container');
    if (container) {
      const placeholder = container.querySelector('.placeholder') as HTMLElement;
      if (placeholder) {
        placeholder.style.display = 'flex';
      }
    }
  }

  addToCart(product: Product): void {
    this.authService.getCurrentUser().subscribe({
      next: (user) => {
        if (user && user.id) {
          const cartItemDTO = {
            userId: user.id,
            productId: product.id,
            quantity: 1,
            price: product.price,
            productName: product.name
          };

          this.cartService.addToCart(cartItemDTO).subscribe({
            next: () => {
              alert('Product added to cart successfully!');
            },
            error: (err) => {
              console.error('Error adding to cart', err);
              alert('Error adding product to cart');
            }
          });
        }
      },
      error: () => {
        alert('Please login to add items to cart');
      }
    });
  }

}