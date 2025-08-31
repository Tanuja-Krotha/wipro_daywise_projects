import { HttpClient } from '@angular/common/http';
import { Injectable, signal } from '@angular/core';
import { Router } from '@angular/router';
import { Role, User, UserDTO } from '../interfaces/user';
import { BehaviorSubject, catchError, Observable, of, tap, throwError } from 'rxjs';
import { Token } from '../interfaces/token';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:9191/user';
  private tokenKey = 'jwtToken';
  private currentUser = signal<User | null>(null);

  constructor(private http: HttpClient, private router: Router) {
    const token = this.getToken();
    if (token) {
      this.getCurrentUser().subscribe();
    }
  }

  login(userDTO: UserDTO): Observable<Token> {
    return this.http.post<Token>(`${this.apiUrl}/login`, userDTO).pipe(
      tap(response => {
        this.storeToken(response.token);
        this.getCurrentUser().subscribe({
          next: (user) => {
            this.redirectBasedOnRole(user.role);
          }
        });
      })
    );
  }

  register(userDTO: UserDTO): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/register`, userDTO);
  }

  getCurrentUser(): Observable<User> {
    const token = this.getToken();
    if (token) {
      try {
        const decoded: any = jwtDecode(token);
        const user: User = {
          id: decoded.id,
          username: decoded.sub || decoded.username,
          email: decoded.email,
          role: decoded.role || Role.CUSTOMER,
          password: '',
          address: decoded.address
        };
        this.currentUser.set(user);
        return new Observable(observer => {
          observer.next(user);
          observer.complete();
        });
      } catch (error) {
        return new Observable(observer => {
          observer.error('Invalid token');
        });
      }
    }
    return new Observable(observer => {
      observer.error('No token found');
    });
  }

  storeToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  isAdmin(): boolean {
    const user = this.currentUser();
    return user ? user.role === Role.ADMIN : false;
  }

  private redirectBasedOnRole(role: Role): void {
    if (role === Role.ADMIN) {
      this.router.navigate(['/admin/products']);
    } else {
      this.router.navigate(['/customer/products']);
    }
  }

  logout(): void {
    localStorage.removeItem(this.tokenKey);
    this.currentUser.set(null);
    this.router.navigate(['/login']);
  }
  
}
