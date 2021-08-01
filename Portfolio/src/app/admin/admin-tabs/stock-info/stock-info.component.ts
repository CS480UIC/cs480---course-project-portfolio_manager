import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-stock-info',
  templateUrl: './stock-info.component.html',
  styleUrls: ['./stock-info.component.css']
})
export class StockInfoComponent implements OnInit {
  public selectedExchangeId: any;
  public selectedCategoryId: any;
  public stockData: any;
  public categoryData: any;
  stockId: any;
  stockName: any;
  industry: any;
  category_Id: any = null;
  market_cap: any;
  exchange_id: any = null;
  exchange_name: any;
  number_of_stock: any;
  category_id: any;
  stockHeaders = ["Stock Id", "Stock Name", "Industry", "Market Cap", "Exchange Name", "Total Stocks"];
  exchangeHeadings = ["stockId", "stockName", "industry", "marketCap", "exchangeName", "numberOfStocks"];
  public stockCategoryData: any;
  public exchangeData: any;

  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AdminService
  ) { }

  ngOnInit(): void {
    
    // get all stock data
    this.appService.getAllStocks().subscribe(
      apiResponse => {
        this.stockData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );

    //get all stock categories
    this.appService.getAllStockCategories().subscribe(
      apiResponse => {
        this.stockCategoryData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );

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

  deleteStock() {
    this.appService.deleteStockById(this.stockId).subscribe(
      apiResponse => {
        alert("Stock Deleted")
      },
      err => {
        if (err.status === 200) {
          alert("Stock Deleted Successfully")
          window.location.reload();
        } else if (err.status === 500) {
          alert("Stock Not found");
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

  public updateStock() {
    this.appService.updateStock(this.stockId, this.stockName).subscribe(
      apiResponse => {
        alert("Stock Name updated")
      },
      err => {
        if (err.status === 200) {
          alert("Stock Name updated Successfully")
          window.location.reload();
        } else {
          alert("Id not found");
        }
      }
    );
  };

  createStock() {
    this.appService.createNewStock(this.stockName, this.selectedExchangeId, this.selectedCategoryId).subscribe(
      apiResponse => {
        alert("Stock Name updated")
      },
      err => {
        if (err.status === 200) {
          alert("Stock Name updated Successfully")
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }


}
