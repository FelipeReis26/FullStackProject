import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Goods } from './goods';

@Injectable({
  providedIn: 'root'
})
export class TransportService {

  private baseUrl = environment.localBaseUrl;

  constructor(private http: HttpClient) { }

  public sendGoods(goods: Goods): Observable<Goods> {
    return this.http.post<Goods>(`${this.baseUrl}/transport/send`, goods);
  }

  public findbyId(id: number): Observable<Goods> {
    return this.http.get<Goods>(`${this.baseUrl}/transport/get/${id}`);
  }

}
