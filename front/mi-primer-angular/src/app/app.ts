import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

// Tuve que importar el CommonModule para poder usar *ngFor y *ngIf
import { CommonModule } from '@angular/common';
import { UserService } from './services/user.service/user.service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('mi-primer-angular');

  users: any[] = [];

  constructor(private userSer: UserService, private chp: ChangeDetectorRef) {
    this.userSer.getUsers().subscribe(data => {
      this.users = data;
      this.chp.detectChanges();
    })
  }
}
