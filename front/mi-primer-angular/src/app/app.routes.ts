import { Routes } from '@angular/router';
import { UserComponent } from './view/user/user.component/user.component';
import { App } from './app';

export const routes: Routes = [
  {path: "", redirectTo: "", pathMatch: "full"},
  {path: "users", component: UserComponent},
];
