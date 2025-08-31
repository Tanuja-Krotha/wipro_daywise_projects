export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
  imageUrl?: string;
}

export interface ProductDTO {
  id?: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
  imageUrl?: string;
}

