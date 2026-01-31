import { Component } from '@angular/core';

import { RickAndMortyService } from '../../../services/rickAndMortyService/rick-and-morty-service';
import { ChangeDetectorRef } from '@angular/core';
@Component({
  selector: 'app-rick-and-morty-component',
  imports: [],
  templateUrl: './rick-and-morty-component.html',
  styleUrl: './rick-and-morty-component.css',
})
export class RickAndMortyComponent {
  characters: any[] = [];
  
    constructor(private rickAndMortyServi: RickAndMortyService, private cdt: ChangeDetectorRef) {
      this.rickAndMortyServi.getRickAndMorty().subscribe((data:any) => {
        this.characters = data?.results;
        console.log(this.characters); //para ver en consola
        this.cdt.detectChanges();
      })
    }
}
