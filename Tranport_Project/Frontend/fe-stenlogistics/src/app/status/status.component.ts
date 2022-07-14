import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Goods } from '../goods';
import { TransportService } from '../transport.service';



@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  goodsList : Goods [] = [];

  goods : Goods = new Goods();

  id : number = 0;

  constructor(private service : TransportService, private route: ActivatedRoute) { }
  

  displayedColumns: string[] = ['id', 'Name','Value', 'Distance', 'Weight'];


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.service.findbyId(this.id).subscribe(
      (response: Goods) => {
        this.goods = response;
        this.goodsList[0] = this.goods;
      },
      (error: HttpErrorResponse) => {
        Swal.fire("Error","Status Not Available",'error');
        console.log(error.message);
      }
    );
  }


}
