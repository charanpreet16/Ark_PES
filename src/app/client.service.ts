import { Injectable } from '@angular/core';
import { HttpClient, HttpClientXsrfModule, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClientUpdateComponent } from './client-update/client-update.component';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  
  private uri = "http://localhost:8080/aurousgroup/";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private httpClient : HttpClient) { }

  addClient(client: Object): Observable<Object> {
    return this.httpClient.post(`${this.uri}` + '/addclient', JSON.stringify(client), this.httpOptions);
  }

  getClientList(): Observable<any> {
    return this.httpClient.get(`${this.uri}` + '/clientlist/');
  }

  getInvestorList() : Observable<any>{
    return this.httpClient.get(`${this.uri}` + '/investorlist/');
  }

  getClient(id: number): Observable<any> {
    return this.httpClient.get(`${this.uri}/${id}`);
  }

  updateClient(id: number, value: any): Observable<Object> {
    return this.httpClient.put(`${this.uri}/${id}`, value);
  }
}