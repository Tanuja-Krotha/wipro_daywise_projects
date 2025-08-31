import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth-service';
import { Router } from '@angular/router';
import { UserDTO } from '../../interfaces/user';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  loginForm: FormGroup;
  errorMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const userDTO: UserDTO = this.loginForm.value;
      this.authService.login(userDTO).subscribe({
        next: () => {
          // Navigation is handled in auth service after successful login
        },
        error: () => {
          this.errorMessage = 'Invalid email or password!';
        }
      });
    }
  }

  navigateToRegister(): void {
    this.router.navigate(['/register']);
  }

}
