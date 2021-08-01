import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { UserService } from 'src/app/user/user.service';
import { PortfolioServiceService } from '../portfolio-service.service';


@Component({
  selector: 'app-user-portfolio',
  templateUrl: './user-portfolio.component.html',
  styleUrls: ['./user-portfolio.component.css']
})
export class UserPortfolioComponent implements OnInit {
  public stockId: any;
  public selectedStockId: any;
  public avgPrice: any;
  public userName: any;
  public portfolioData: any;
  public createdDate: any;
  public quantity: any;

  portfolioHeaders = ["stockId", "stockName", "quantity", "avgPrice", "exchangeName", "industryName",
    "latestTransactionDate"];
  portfolioHeadings = ["Stock ID", "Stock Name", "Quantity", "Average Price",
    "Exchange Name", "Industry Name", "Latest Transaction Date"];
  public userId: any;
  stockData: any;

  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: PortfolioServiceService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log(params)
      this.userId = params.userId;
    });
    //get portfolio for user
    this.appService.getPortfolioByUserId(this.userId).subscribe(
      apiResponse => {
        this.portfolioData = apiResponse;
        this.userName = this.portfolioData[0].userName;
      },
      err => {
        alert("some error occured");
      }
    );

    // get all stock data
    this.appService.getAllStocks().subscribe(
      apiResponse => {
        console.log(apiResponse)
        this.stockData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );

  }

  createPortfolio() {
    this.appService.createNewStock(this.userId, this.avgPrice, this.quantity,
      this.createdDate, this.selectedStockId).subscribe(
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

  updateStock() {
    this.appService.updatePortfolio(this.userId, this.stockId, this.avgPrice, this.quantity,
      this.createdDate).subscribe(
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
   }

  deleteStock() {
    this.appService.deletePortfolio(this.userId, this.stockId).subscribe(
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


}


