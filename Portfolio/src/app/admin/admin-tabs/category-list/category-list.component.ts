import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { UserService } from 'src/app/user/user.service';
import { AdminService } from '../admin.service';
@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  public stockCategoryData: any;
  public categoryId: string = "";
  public marketCap: any;
  public industry: any;
  stockCategoryHeaders = ["category_id", "industry", "market_cap"];
  stockCategoryHeadings = ["Category Id", "Industry", "Market Cap"];

  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AdminService
  ) { }
  ngOnInit(): void {
    //get all stock categories
    this.appService.getAllStockCategories().subscribe(
      apiResponse => {
        this.stockCategoryData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }

  deleteStockCategory() {
    this.appService.deleteStockCategoryById(this.categoryId).subscribe(
      apiResponse => {
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

  public updateStockCategory() {
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

  sortById(){
    //get all exchanges
    this.appService.getAllStockCategories().subscribe(
      apiResponse => {
        this.stockCategoryData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }
  sortByName(){
    //get all exchanges
    this.appService.getAllCategorySorted().subscribe(
      apiResponse => {
        this.stockCategoryData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }

}
