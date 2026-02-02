import { Routes } from '@angular/router';
import { UserComponent } from './view/user/user.component/user.component';
import { App } from './app';
import { RickAndMortyComponent } from './view/rickAndMorty/rick-and-morty-component/rick-and-morty-component';

export const routes: Routes = [
  // {path: "", redirectTo: "", pathMatch: "full"},
  {path: "users", component: UserComponent},
  {path: "rickandmorty", component: RickAndMortyComponent},
  {path: "**", redirectTo: ""}
];
