import {CarHouse} from "./car-house";

export interface Ticket {
  id?:number,
  price?:number,
  startPoint?:string,
  endPoint?:string,
  startDate?:string,
  startTime?:string,
  amount?:number,
  garage?:CarHouse
}
