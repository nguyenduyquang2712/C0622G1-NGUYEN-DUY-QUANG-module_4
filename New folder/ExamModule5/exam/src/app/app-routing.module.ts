import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {NavigationComponent} from "./navigation/navigation.component";
import {TicketComponent} from "./ticket/ticket.component";
import {CreateTicketComponent} from "./create-ticket/create-ticket.component";
import {EditTicketComponent} from "./edit-ticket/edit-ticket.component";


const routes: Routes = [{
  path: "", component: TicketComponent
},
  {
    path:"create", component:CreateTicketComponent
  },
  {
    path:"edit/:id",component:EditTicketComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
