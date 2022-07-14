import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Goods } from '../goods';
import { TransportService } from '../transport.service';
@Component({
  selector: 'app-transport',
  templateUrl: './transport.component.html',
  styleUrls: ['./transport.component.css']
})
export class TransportComponent implements OnInit {

  constructor(private service : TransportService, private router: Router) { }

  successflag = false;

  goods : Goods = new Goods();

  goodsId : number = 0;

  ngOnInit(): void {
  }

  formSubmit(){
    if (!isNaN(+this.goods.type)) {
      Swal.fire('Name Error', 'It must be a name!', 'error')
      return;
    }

    if (isNaN(+this.goods.value)) {
      Swal.fire('Value', 'Value must be a nuber!', 'error')
      return;
    }

    if (isNaN(+this.goods.distance)) {
      Swal.fire('Distance', 'Distance must be a nuber!', 'error')
      return;
    }

    if (isNaN(+this.goods.weight)) {
      Swal.fire('Weight', 'Weight must be in nuber!', 'error')
      return;
    } 

    if(this.goods.value == 0){
      Swal.fire('Value', "Value Can't be Zero", 'error')
      return;
    }

    if( this.goods.distance == 0){
      Swal.fire('Distance', "Distance Can't be Zero", 'error')
      return;
    }

    if(this.goods.weight == 0){
      Swal.fire('Weight', "Weight Can't be Zero", 'error')
      return;
    }

    this.service.sendGoods(this.goods).subscribe(
      (response: Goods) => {
        this.goodsId= response.id;
        Swal.fire('Success','Your Tranport is on the way to its Destination','success');
        this.successflag = true;
      },
      (error: HttpErrorResponse) => {
        Swal.fire("Can't Procced",error.error.message,'error');
        this.successflag = false;
      }
    );


  }

  statusPage(){
    this.router.navigate(['status',this.goodsId]);
  }

}
