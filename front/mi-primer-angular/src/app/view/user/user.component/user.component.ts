import { Component } from '@angular/core';
// import { JsonPipe } from '@angular/common'; <-- no necesario

import { UserService } from '../../../services/user.service/user.service';

import { ChangeDetectorRef } from '@angular/core';


@Component({
  selector: 'app-user.component',
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
})
export class UserComponent {
  
  users: any[] = [];

  constructor(private userServi: UserService, private cdt: ChangeDetectorRef) {
    this.userServi.getUsers().subscribe(data => {
      this.users = data;
      this.cdt.detectChanges();
    })
  }
}
