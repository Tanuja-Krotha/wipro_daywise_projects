import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product, ProductDTO } from '../interfaces/product';

@Injectable({
  providedIn: 'root'
})
  export class ProductService {
  private apiUrl = 'http://localhost:8082/products';

  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/${id}`);
  }

  createProduct(productDTO: ProductDTO): Observable<Product> {
    const formData = new FormData();
    formData.append('name', productDTO.name);
    formData.append('description', productDTO.description);
    formData.append('price', productDTO.price.toString());
    formData.append('quantity', productDTO.quantity.toString());
    if (productDTO.imageUrl) {
      formData.append('image', productDTO.imageUrl);
    }

    return this.http.post<Product>(this.apiUrl, formData);
  }

  updateProduct(id: number, productDTO: ProductDTO): Observable<Product> {
    const formData = new FormData();
    formData.append('name', productDTO.name);
    formData.append('description', productDTO.description);
    formData.append('price', productDTO.price.toString());
    formData.append('quantity', productDTO.quantity.toString());
    if (productDTO.imageUrl) {
      formData.append('image', productDTO.imageUrl);
    }

    return this.http.put<Product>(`${this.apiUrl}/${id}`, formData);
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getProductQuantity(id: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/${id}/quantity`);
  }
  
}
