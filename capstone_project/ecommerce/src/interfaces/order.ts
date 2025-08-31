export interface Order {
  id: number;
  userId: number;
  orderDate: string;
  status: OrderStatus;
  totalAmount: number;
  items: OrderItem[];
}

export interface OrderItem {
  id: number;
  productId: number;
  quantity: number;
  price: number;
  productName: string;
}

export enum OrderStatus {
  PENDING = 'PENDING',
  CREATED = 'CREATED',
  SHIPPED = 'SHIPPED',
  DELIVERED = 'DELIVERED',
  CANCELLED = 'CANCELLED'
}

export interface OrderEvent {
  type: string;
  productId: number;
  quantity: number;
  orderId: number;
  userId: number;
  timestamp: string;
}
