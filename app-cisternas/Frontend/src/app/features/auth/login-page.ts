import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  imports: [FormsModule],
  templateUrl: './login-page.html',
  styleUrl: './login-page.scss'
})
export class LoginPage {
  email = '';
  password = '';
  mostrarPassword = false;
  verificando = false;

  constructor(private readonly router: Router) {}

  alternarPassword(): void {
    this.mostrarPassword = !this.mostrarPassword;
  }

  iniciarSesion(): void {
    this.verificando = true;

    window.setTimeout(() => {
      this.verificando = false;
      this.router.navigate(['/dashboard']);
    }, 1500);
  }
}
