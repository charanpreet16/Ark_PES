import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { ClientComponent } from './client/client.component';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClientGetComponent } from './client-get/client-get.component';
import { ClientAddComponent } from './client-add/client-add.component';
import { ClientUpdateComponent } from './client-update/client-update.component';
import { SlimLoadingBarModule } from 'ng2-slim-loading-bar';
import { from } from 'rxjs';
import { ClientService } from './client.service';


@NgModule({
  declarations: [
    AppComponent,
  //  ClientComponent,
    ClientGetComponent,
    ClientAddComponent,
    ClientUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    SlimLoadingBarModule,
    ReactiveFormsModule
  ],
  providers: [ ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
