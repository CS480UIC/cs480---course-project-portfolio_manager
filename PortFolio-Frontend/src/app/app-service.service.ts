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
export class AppServiceService {
  baseURL = "http://localhost:8080/PortfolioManager/api";
  constructor(private http: HttpClient) { }

  public signinFunction(userData: any): Observable<any> {
    return this.http.get(`${this.baseURL}/getUserByName/${userData.emailId}/${userData.userPassword}`);
  }

}
