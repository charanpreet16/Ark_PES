import { Component, OnInit } from '@angular/core';
import { client } from '../client';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../client.service';
import { error } from 'protractor';

@Component({
  selector: 'app-client-update',
  templateUrl: './client-update.component.html',
  styleUrls: ['./client-update.component.css']
})
export class ClientUpdateComponent implements OnInit {
  

  clientId : number;
  client : client;

  constructor(private route : ActivatedRoute , private router : Router, 
    private clientService: ClientService) { }

  ngOnInit() {

    this.client = new client();
    this.clientId = this.route.snapshot.params['clientId'];
    this.clientService.getClient(this.clientId).subscribe(data => {
      console.log(data)
      this.client = data;
      this.gotoList();
    }, error => console.log(error));
  }

  updateClient(){
    this.clientService.updateClient(this.clientId,this.client)
    .subscribe(data => console.log(data),error => console.log(error));
    this.client = new client();
    this.gotoList();
  }

  onSubmit() {
    this.updateClient();    
  }

  gotoList() {
    this.router.navigate['/clients'];
  }

}