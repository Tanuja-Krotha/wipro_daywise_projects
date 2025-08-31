import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Product, ProductDTO } from '../../interfaces/product';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/productservice';

@Component({
  selector: 'app-product-form-component',
  imports: [ReactiveFormsModule,CommonModule,RouterModule,FormsModule],
  templateUrl: './product-form-component.html',
  styleUrl: './product-form-component.css'
})
export class ProductFormComponent implements OnInit {
productForm: FormGroup;
  isEditMode = false;
  productId?: number;
  isLoading = false;

  constructor(
    private fb: FormBuilder,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.productForm = this.createForm();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isEditMode = true;
        this.productId = +params['id'];
        this.loadProduct(this.productId);
      }
    });
  }

  createForm(): FormGroup {
    return this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      description: [''],
      price: [0, [Validators.required, Validators.min(0)]],
      quantity: [0, [Validators.required, Validators.min(0)]],
      imageUrl: [''] // Simple URL input instead of file upload
    });
  }

  loadProduct(id: number): void {
    this.isLoading = true;
    this.productService.getProductById(id).subscribe({
      next: (product) => {
        this.productForm.patchValue({
          name: product.name,
          description: product.description,
          price: product.price,
          quantity: product.quantity,
          imageUrl: product.imageUrl
        });
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error loading product', err);
        this.isLoading = false;
      }
    });
  }
   handleImageError(event: Event): void {
    const imgElement = event.target as HTMLImageElement;
    imgElement.style.display = 'none';
    
    // Optional: Show error message
    const container = imgElement.parentElement;
    if (container) {
      const errorDiv = document.createElement('div');
      errorDiv.className = 'text-danger small mt-1';
      errorDiv.textContent = 'Failed to load image';
      container.appendChild(errorDiv);
    }
  }

  onSubmit(): void {
    if (this.productForm.valid) {
      this.isLoading = true;
      const productData: Product = {
        id: this.productId,
        ...this.productForm.value
      };

      const operation = this.isEditMode
        ? this.productService.updateProduct(this.productId!, productData)
        : this.productService.createProduct(productData);

      operation.subscribe({
        next: () => {
          this.isLoading = false;
          alert(`Product ${this.isEditMode ? 'updated' : 'created'} successfully!`);
          this.router.navigate(['/admin/products']);
        },
        error: (err) => {
          console.error('Error saving product', err);
          this.isLoading = false;
          alert('Error saving product');
        }
      });
    } else {
      this.markFormGroupTouched();
    }
  }

  private markFormGroupTouched(): void {
    Object.keys(this.productForm.controls).forEach(key => {
      this.productForm.get(key)?.markAsTouched();
    });
  }

  onCancel(): void {
    this.router.navigate(['/admin/products']);
  }

  // Preview the image from URL
  get imagePreview(): string {
    return this.productForm.get('imageUrl')?.value || '';
  }



}
