import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ticket} from "../model/ticket";
import {Observable} from "rxjs";
import {CarHouse} from "../model/car-house";
import {TicketDto} from "../dto/ticket-dto";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private _tickets:Ticket[];
  constructor(private _httpClient: HttpClient) { }
  findAll(startPoint:string, endPoint:string):Observable<Ticket[]>{
      return this._httpClient.get<Ticket[]>('http://localhost:3000/tickets'+'?startPoint_like='+startPoint+'&endPoint_like='+endPoint);
  }
  findAllTicket():Observable<Ticket[]>{
    return this._httpClient.get<Ticket[]>('http://localhost:8080/api/ticket');
  }
  findAllHouse():Observable<CarHouse[]>{
    return this._httpClient.get<CarHouse[]>('http://localhost:8080/api/garage');
  }

  save(ticket: Ticket):Observable<Ticket> {
    return this._httpClient.post<Ticket>('http://localhost:8080/api/ticket/create',ticket)
  }

  findTicketById(IdEditTicket: number):Observable<Ticket> {
    return this._httpClient.get<Ticket>('http://localhost:8080/api/ticket/'+IdEditTicket);
  }

  editTicket(ticketDTO: TicketDto): Observable<TicketDto> {
    return this._httpClient.put<TicketDto>('http://localhost:8080/api/ticket/edit',ticketDTO)
  }

  deleteById(deleteTicketId: number):Observable<void>  {
return this._httpClient.delete<void>('http://localhost:8080/api/ticket/'+deleteTicketId)
  }

  searchTicket(startPoint: string, endPoint: string, firstDate: string, secondDate: string):Observable<Ticket[]> {
      return this._httpClient.get<Ticket[]>('http://localhost:8080/api/ticket/search'+"?startPoint=" + startPoint + "&endPoint=" + endPoint
        + "&firstDay=" + firstDate + "&secondDay=" + secondDate)
  }

  order(id: number, ticketBooking: Ticket):Observable<Ticket> {
    return this._httpClient.put<Ticket>('http://localhost:8080/api/ticket/booking/' + id, ticketBooking)
  }
}
