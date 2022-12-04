import { Component, OnInit } from '@angular/core';
import {Ticket} from "../model/ticket";
import {CarHouse} from "../model/car-house";
import {TicketService} from "../service/ticket.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
  tickets:Ticket[]=[];
  ticketBooking: Ticket;
  carHouseList:CarHouse[];
  deleteTicketId: number = 0;
  defaultStartDate:string='';
  defaultEndDate:string='';

  p:number=1;
  constructor(private _ticketService: TicketService,
              private toast:ToastrService) { }

  ngOnInit(): void {
    this._ticketService.findAllTicket().subscribe(data=>{
      console.log(data);
      this.tickets=data;
    })
  }

  search(startPoint: string, endPoint: string, startDate: string, endDate: string) {
      this.p=1;
      this.setDefault(startDate,endDate)
      this._ticketService.searchTicket(startPoint,endPoint, this.defaultStartDate,this.defaultEndDate).subscribe(data=>{
        this.tickets=data;
      })
  }

  getDeleteInfo(id: number) {
    this.deleteTicketId=id;
  }

  deleteTicketById() {
    this._ticketService.deleteById(this.deleteTicketId).subscribe(() => {
      this.toast.success('Ticket deleted successfully')
      this.ngOnInit();
    })
  }

  private setDefault(startDate: string, endDate: string) {
    if(startDate==''){
      this.defaultStartDate='0001-01-01';
    }
    else{
      this.defaultStartDate=startDate;
    }
    if(endDate==''){
      this.defaultEndDate='9999-01-01';
    }
    else{
      this.defaultEndDate=endDate;
    }
  }

  infoBooking(id: number) {
    this._ticketService.findTicketById(id).subscribe(data => {
      this.ticketBooking = data;
    })
  }

  orderTicket(id: number) {
    if (this.ticketBooking.amount == 0) {
      this.toast.success("het ve")
    } else {
      this._ticketService.order(id, this.ticketBooking).subscribe(data => {
        this.ngOnInit();
        this.toast.success("Đặt vé xe thành công!");
      })
    }
  }
}
