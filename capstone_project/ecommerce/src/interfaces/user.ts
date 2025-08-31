export interface User {
  id?: number;
  username: string;
  email: string;
  password: string;
  address?: string;
  role: Role;
}
export enum Role {
  ADMIN = 'ADMIN',
  CUSTOMER = 'CUSTOMER'
}

export interface UserDTO {
  id?: number;
  username?: string;
  email: string;
  password: string;
  address?: string;
  role?: Role;
}