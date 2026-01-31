import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class RickAndMortyService {
  constructor(private http: HttpClient) {}

  getRickAndMorty() {
    // return this.http.get<any[]>('users.json')
    return this.http.get<any[]>('https://rickandmortyapi.com/api/character/')
  }
}
