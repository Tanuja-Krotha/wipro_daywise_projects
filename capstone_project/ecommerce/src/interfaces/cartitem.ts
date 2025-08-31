export interface CartItem {
  id?: number;
  userId: number;
  productId: number;
  quantity: number;
  price: number;
  productName: string;
}

export interface CartItemDTO {
  id?: number;
  userId: number;
  productId: number;
  quantity: number;
  price: number;
  productName: string;
}
