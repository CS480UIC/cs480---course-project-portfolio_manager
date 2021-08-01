import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-users-portfolio',
  templateUrl: './users-portfolio.component.html',
  styleUrls: ['./users-portfolio.component.css']
})
export class UsersPortfolioComponent implements OnInit {
  userPortfolioHeaders = ["userId", "userName", "stockName", "quantity", "avgPrice", "latestTransactionDate"];
  userPortfolioHeadings = ["User Id", "User Name", "Stock Name", "Quantity", 
                          "Average Price", "latest Transaction Date"];
  userPortfolioData: any;

  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AdminService
  ) { }

  ngOnInit(): void {
    //get all users portfolios
    this.appService.getAllUserPortfolio().subscribe(
      apiResponse => {
        this.userPortfolioData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }
}


