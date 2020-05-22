import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientGetComponent } from './client-get/client-get.component';
import { ClientAddComponent } from './client-add/client-add.component';
import { ClientUpdateComponent } from './client-update/client-update.component';
import { from } from 'rxjs';

const routes: Routes = [
{path : '' , redirectTo : 'client' , pathMatch:'full'},
{ path : 'clients',  component : ClientGetComponent},
{path : 'client/add', component : ClientAddComponent},
{path : 'update/:id' , component : ClientUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
