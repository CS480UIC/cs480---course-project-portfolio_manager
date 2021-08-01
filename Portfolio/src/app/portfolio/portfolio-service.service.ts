import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpClientModule,
  HttpParams
} from "@angular/common/http";
import { Observable, observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PortfolioServiceService {
  baseURL = "http://localhost:8080/PortfolioManager/api";
  constructor(private http: HttpClient) { }

  /*********************************************************************************************** */
  // Stock info Api's
  public getPortfolioByUserId(userId: any) {
    return this.http.get(`${this.baseURL}/getPortfolioForUserId/${userId}`);
  }

  public deletePortfolio(userId: any, stockId: any): Observable<any> {
    return this.http.delete(`${this.baseURL}/deletePortfolio/${userId}/${stockId}`);
  }

  public updatePortfolio(userId: any, stockId: any, price: any, totalQty: any,
    dateOfTransaction: any): Observable<any> {
    return this.http.put(`${this.baseURL}/updatePortfolioForUser/
          ${userId}/${stockId}/${price}/${totalQty}/${dateOfTransaction}`, stockId);
  }

  public createNewStock(userId: any, avgPrice: any, quantity: any, createdDate: any, stockId: any): Observable<any> {
    const params = new URLSearchParams()
    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };

    console.log(userId, stockId, avgPrice, quantity, createdDate)
    params.set("user_id", userId)
    params.set("stock_id", stockId)
    params.set("avg_price", avgPrice)
    params.set("quantity", quantity)
    params.set("latest_transaction_date", createdDate)
    return this.http.post(`${this.baseURL}/addPortfolioRow`, params, options);
  }

  // Stock info Api's
  public getAllStocks() {
    return this.http.get(`${this.baseURL}/getAllStocks`);
  }
}
