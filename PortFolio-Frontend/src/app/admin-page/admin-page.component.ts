import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AppServiceService } from '../app-service.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {
  public adminName: any;
  public userId: string = "";
  public categoryId: string = "";
  public exchangeId: string = "";

  public userData: any;
  public stockCategoryData: any;
  public exchangeData: any;
  public adminData: any;
  userHeaders = ["user_id", "user_name", "email_id", "contact"];
  userHeadings = ["User Id", "User Name", "Email Id", "Contact"];
  stockCategoryHeaders = ["category_id", "industry", "market_cap"];
  stockCategoryHeadings = ["Category Id", "Industry", "Market Cap"];
  exchangeHeaders = ["exchange_id", "exchange_name", "number_of_stocks"];
  exchangeHeadings = ["Exchange Id", "Exchange Name", "Number of Stocks"];

  public exchangeName: any;
  public industry: any;

  public numOfStocks: any;
  public marketCap: any;


  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AppServiceService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.adminName = params;
    });
    console.log(this.adminName.userId)
    // get all user data
    this.appService.getAllUsers().subscribe(
      apiResponse => {
        console.log(apiResponse);
        this.userData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
    //get all stock categories
    this.appService.getAllStockCategories().subscribe(
      apiResponse => {
        console.log(apiResponse);
        this.stockCategoryData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );

    //get all echanges
    this.appService.getAllExchanges().subscribe(
      apiResponse => {
        console.log(apiResponse);
        this.exchangeData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  };

  deleteUser() {
    this.appService.deleteUserById(this.userId).subscribe(
      apiResponse => {
        console.log(apiResponse);
        alert("User Deleted")
      },
      err => {
        if (err.status === 200) {
          alert("User Deleted Successfully")
          window.location.reload();
        } else if (err.status === 500) {
          alert("User Not found");
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

  deleteStockCategory() {
    this.appService.deleteStockCategoryById(this.categoryId).subscribe(
      apiResponse => {
        console.log(apiResponse);
        alert("StockCategory Deleted")
      },
      err => {
        if (err.status === 200) {
          alert("Stock Category Deleted Successfully")
          window.location.reload();
        } else if (err.status === 500) {
          alert("Stock Category Not found");
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

  deleteExchange() {
    this.appService.deleteExchangeById(this.exchangeId).subscribe(
      apiResponse => {
        console.log(apiResponse);
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

  public updateStockCategory() {
    console.log(this.marketCap);
    this.appService.updateStockCategory(this.categoryId, this.marketCap).subscribe(
      apiResponse => {
        console.log(apiResponse);
        alert("Market Cap updated")
      },
      err => {
        if (err.status === 200) {
          alert("Market Cap updated Successfully")
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  };

  public updateExchange() {
    console.log(this.marketCap);
    this.appService.updateExchangeStock(this.exchangeId, this.numOfStocks).subscribe(
      apiResponse => {
        console.log(apiResponse);
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

  public createStockCategory() {
    this.appService.createNewStockCategory(this.industry, this.marketCap).subscribe(
      apiResponse => {
        console.log(apiResponse);
      },
      err => {
        console.log(err);
        if (err.status === 200) {
          alert("Category Created Successfully")
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

  createExchange() {
    console.log(this.exchangeName, this.numOfStocks)
    this.appService.createNewExchange(this.exchangeName, this.numOfStocks).subscribe(
      apiResponse => {
        console.log(apiResponse);
      },
      err => {
        console.log(err);
        if (err.status === 200) {
          alert("Exchange Created Successfully")
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

}
