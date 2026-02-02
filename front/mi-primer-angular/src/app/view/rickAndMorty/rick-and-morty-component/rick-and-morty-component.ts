import { Component } from '@angular/core';
import { OnInit } from '@angular/core';

import { RickAndMortyService } from '../../../services/rickAndMortyService/rick-and-morty-service';
import { Character, RickAndMortyInterface } from '../rick-and-morty-interface/rickAndMortyInterface';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-rick-and-morty-component',
  imports: [],
  templateUrl: './rick-and-morty-component.html',
  styleUrl: './rick-and-morty-component.css',
})
export class RickAndMortyComponent implements OnInit {
  characters:  Character[] = [];

  constructor(private rickAndMortyService: RickAndMortyService, private cdt: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.rickAndMortyService.getRickAndMorty().subscribe((data:RickAndMortyInterface)=>{
      this.characters = data.results;
      this.cdt.detectChanges();
    })
  }
}
