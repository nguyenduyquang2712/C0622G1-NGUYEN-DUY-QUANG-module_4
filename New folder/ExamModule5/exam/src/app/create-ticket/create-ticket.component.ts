import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators, ValidationErrors} from "@angular/forms";
import {CarHouse} from "../model/car-house";
import {TicketService} from "../service/ticket.service";
import {ToastrService} from "ngx-toastr";

// export const checkStartDay: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
//   const startDay = new Date(control.get("startDay").value).getTime();
//   console.log(startDay)
//   const dateNow = new Date().getTime();
//   console.log(dateNow)
//   if (startDay - dateNow < 24 * 60 * 60 * 1000) {
//     return {"checkStartDay": true};
//   } else {
//     return null;
//   }
// }

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})



export class CreateTicketComponent implements OnInit {
  newTicket: FormGroup;
  garageList: CarHouse[];
  error:any;
  constructor(private _ticketService: TicketService,
              private toast: ToastrService,
              private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this._ticketService.findAllHouse().subscribe(data => {
      console.log(data)
      this.garageList = data;
      })
    this.newTicket = this._formBuilder.group({
      price:['',[Validators.required,Validators.pattern("^\\d+$")]],
      startPoint:['',[Validators.required]],
      endPoint:['',[Validators.required]],
      startDate:['',[Validators.required]],
      startTime:['',[Validators.required,Validators.pattern("[0-9]{2}(:)[0-9]{2}")]],
      amount:['',[Validators.required,Validators.pattern("^\\d+$")]],
      garageId:['',[Validators.required]]
    })
  }

  createTicket() {
      this._ticketService.save(this.newTicket.value).subscribe(data=>{
        this.toast.success("them moi thanh cong", "them moi");
      },
        error => {
          this.error=error.message;
        })
  }
}
