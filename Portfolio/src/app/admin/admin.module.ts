import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListComponent } from './admin-tabs/user-list/user-list.component';
import { CategoryListComponent } from './admin-tabs/category-list/category-list.component';
import { ExchangeListComponent } from './admin-tabs/exchange-list/exchange-list.component';
import { StockInfoComponent } from './admin-tabs/stock-info/stock-info.component';
import { UsersPortfolioComponent } from './admin-tabs/users-portfolio/users-portfolio.component';

@NgModule({
  declarations: [
    UserListComponent,
    CategoryListComponent,
    ExchangeListComponent,
    StockInfoComponent,
    UsersPortfolioComponent,
  ],
  imports: [
    CommonModule
  ]
})
export class AdminModule { }
