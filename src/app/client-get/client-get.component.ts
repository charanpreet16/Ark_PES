import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { client } from '../client';
import {ClientService } from '../client.service';
import { Router } from '@angular/router';
import { investor } from '../investor';

@Component({
  selector: 'app-client-get',
  templateUrl: './client-get.component.html',
  styleUrls: ['./client-get.component.css']
})
export class ClientGetComponent implements OnInit {

  clients : Observable<client[]>;
  investors : Observable<investor[]>;
  
  
  constructor(private clientService : ClientService, private router : Router) { }

  ngOnInit() : void {
    this.reloadData();
  }

  reloadData() {
    this.clients = this.clientService.getClientList();
  }

  clientDetails(id: number){
    this.router.navigate(['details', id]);
  }

}