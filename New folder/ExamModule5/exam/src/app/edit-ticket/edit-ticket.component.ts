import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {TicketDto} from "../dto/ticket-dto";
import {CarHouse} from "../model/car-house";
import {TicketService} from "../service/ticket.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-edit-ticket',
  templateUrl: './edit-ticket.component.html',
  styleUrls: ['./edit-ticket.component.css']
})
export class EditTicketComponent implements OnInit {
  editTicket: FormGroup;
  IdEditTicket: number;
  ticketDTO: TicketDto;
  garageList: CarHouse[];

  constructor(private _ticketService: TicketService,
              private _formBuilder: FormBuilder,
              private _activatedRoute: ActivatedRoute,
              private toastr: ToastrService,
              private route: Router) {
  }

  ngOnInit(): void {
    this._ticketService.findAllHouse().subscribe(data => {
      this.garageList = data;
    })
    this._activatedRoute.params.subscribe((param: Params) => {
      this.IdEditTicket = param['id'];
      this._ticketService.findTicketById(this.IdEditTicket).subscribe(data => {
        this.editTicket = this._formBuilder.group({
          id: [data.id],
          price: [data.price],
          startPoint: [data.startPoint],
          endPoint: [data.endPoint],
          startDate: [data.startDate],
          startTime: [data.startTime],
          amount: [data.amount],
          garageId: [data.garage.id]
        })
      })
    })
  }

  updateTicket() {
    this.ticketDTO= this.editTicket.value;
    this._ticketService.editTicket(this.ticketDTO).subscribe(data=>{
      this.route.navigateByUrl('/');
    });
  }
}
