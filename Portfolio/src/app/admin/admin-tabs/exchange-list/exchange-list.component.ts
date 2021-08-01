import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-exchange-list',
  templateUrl: './exchange-list.component.html',
  styleUrls: ['./exchange-list.component.css']
})
export class ExchangeListComponent implements OnInit {
  public exchangeData: any;
  public exchangeId: string = "";
  public marketCap: any;

  public exchangeName: any;
  public numOfStocks: any;
  exchangeHeaders = ["exchange_id", "exchange_name", "number_of_stock"];
  exchangeHeadings = ["Exchange Id", "Exchange Name", "Number of Stocks"];


  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AdminService
  ) { }

  ngOnInit(): void {
    //get all exchanges
    this.appService.getAllExchanges().subscribe(
      apiResponse => {
        this.exchangeData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }

  deleteExchange() {
    this.appService.deleteExchangeById(this.exchangeId).subscribe(
      apiResponse => {
        alert("Exchange Deleted")
      },
      err => {
        if (err.status === 200) {
          alert("Exchange Deleted Successfully")
          window.location.reload();
        } else if (err.status === 500) {
          alert("Exchange Not found");
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

  public updateExchange() {
    this.appService.updateExchangeStock(this.exchangeId, this.numOfStocks).subscribe(
      apiResponse => {
        alert("Number of Stocks updated")
      },
      err => {
        if (err.status === 200) {
          alert("Number of Stocks updated Successfully")
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  };

  createExchange() {
    this.appService.createNewExchange(this.exchangeName, this.numOfStocks).subscribe(
      apiResponse => {
      },
      err => {
        if (err.status === 200) {
          alert("Exchange Created Successfully")
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

  sortById(){
    //get all exchanges
    this.appService.getAllExchanges().subscribe(
      apiResponse => {
        this.exchangeData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }
  sortByName(){
    //get all exchanges
    this.appService.getAllExchangesSorted().subscribe(
      apiResponse => {
        this.exchangeData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }

}
