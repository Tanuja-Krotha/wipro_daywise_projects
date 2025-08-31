import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User, UserDTO } from '../interfaces/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

   private apiUrl = 'http://localhost:9191/user';

  constructor(private http: HttpClient) { }

  updateUser(id: number, userDTO: UserDTO): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/${id}`, userDTO);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }

  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/username/${username}`);
  }
  
}
