import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StatusComponent } from './status/status.component';
import { TransportComponent } from './transport/transport.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, pathMatch: 'full' },
  { path: 'transport', component: TransportComponent, pathMatch: 'full'},
  { path: 'status/:id', component: StatusComponent, pathMatch: 'full' },
];
 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
