import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { client } from '../client';
import { ClientService } from '../client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-add',
  templateUrl: './client-add.component.html',
  styleUrls: ['./client-add.component.css']
})
export class ClientAddComponent implements OnInit {
  
  client : client = new client();
  submitted = false;


  constructor(private clientService : ClientService, private router:Router) {
    
   }

  ngOnInit(): void {
  }

  newClient() : void {
    this.submitted = false;
    this.client = new client();
  }

  save(){
    this.clientService.addClient(this.client)
    .subscribe(data => console.log(data) , error => console.log(error));
    this.client = new client();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/clients']);
  }

}