import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpClientModule,
  HttpParams
} from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  baseURL = "http://localhost:8080/PortfolioManager/api";
  constructor(private http: HttpClient) { }
  /*********************************************************************************************** */
  // Stock category Api's
  public getAllStockCategories() {
    return this.http.get(`${this.baseURL}/getAllStockCategories`);
  }

  public deleteStockCategoryById(categoryId: any): Observable<any> {
    console.log(categoryId);
    return this.http.delete(`${this.baseURL}/deleteStockCategory/${categoryId}`);
  }

  public updateStockCategory(categoryId: any, marketCap: any): Observable<any> {
    console.log(categoryId, marketCap);
    return this.http.put(`${this.baseURL}/updateStockCategory/${categoryId}/${marketCap}`, categoryId, marketCap);
  }

  public createNewStockCategory(industry: any, marketCap: any): Observable<any> {
    const params = new URLSearchParams()
    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };
    params.set("industry", industry)
    params.set("market_cap", marketCap)
    return this.http.post(`${this.baseURL}/addCategory`, params, options);
  }

  public getAllCategorySorted() {
    return this.http.get(`${this.baseURL}/getAllCategoriesSortedByIndustry`);
  }

  /*********************************************************************************************** */
  // Exchanges Api's
  public getAllExchanges() {
    return this.http.get(`${this.baseURL}/getAllExchanges`);
  }

  public deleteExchangeById(exchangeId: any): Observable<any> {
    console.log(exchangeId);
    return this.http.delete(`${this.baseURL}/deleteExchange/${exchangeId}`);
  }

  public updateExchangeStock(exchangeId: any, numOfStocks: any): Observable<any> {
    console.log(exchangeId, numOfStocks);
    return this.http.put(`${this.baseURL}/updateExchangeInfo/${exchangeId}/${numOfStocks}`, exchangeId, numOfStocks);
  }

  public createNewExchange(exchangeName: any, numOfStocks: any): Observable<any> {
    const params = new URLSearchParams()
    console.log(exchangeName, numOfStocks);
    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };
    params.set("exchange_name", exchangeName)
    params.set("number_of_stock", numOfStocks)
    return this.http.post(`${this.baseURL}/addNewExchange`, params, options);
  }

  public getAllExchangesSorted() {
    return this.http.get(`${this.baseURL}/getAllExchangesSortedByName`);
  }

  /*********************************************************************************************** */
  // Stock info Api's
  public getAllStocks() {
    return this.http.get(`${this.baseURL}/getAllStocks`);
  }

  public deleteStockById(stockId: any): Observable<any> {
    console.log(stockId);
    return this.http.delete(`${this.baseURL}/deleteStockInfo/${stockId}`);
  }

  public updateStock(stockId: any, stockName: any): Observable<any> {
    console.log(stockId, stockName);
    return this.http.put(`${this.baseURL}/updateStockInfo/${stockId}/${stockName}`, stockId, stockName);
  }

  public createNewStock(stockName: any, exchangeId: any, categoryId: any): Observable<any> {
    const params = new URLSearchParams()
    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };
    params.set("stock_name", stockName)
    params.set("exchange_id", exchangeId)
    params.set("category_id", categoryId)

    return this.http.post(`${this.baseURL}/addNewStockInfo`, params, options);
  }

  /*********************************************************************************************** */
  // Portfolio Api's
  public getAllUserPortfolio() {
    return this.http.get(`${this.baseURL}/getAllPortfoliosForAllUsers`);
  }
  public getGroupByPortfolio(userId: any) {
    return this.http.get(`${this.baseURL}/getGroupedDataAccordingToUsers/${userId}`);
  }
  
}
