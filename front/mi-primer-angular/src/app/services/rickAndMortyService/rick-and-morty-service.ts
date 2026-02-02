import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RickAndMortyInterface } from '../../view/rickAndMorty/rick-and-morty-interface/rickAndMortyInterface';

@Injectable({
  providedIn: 'root',
})
export class RickAndMortyService {
  constructor(private http: HttpClient) {}

  getRickAndMorty(){
    return this.http.get<RickAndMortyInterface>('https://rickandmortyapi.com/api/character');
  }
}
