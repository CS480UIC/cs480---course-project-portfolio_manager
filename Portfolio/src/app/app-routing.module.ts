import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminTabsComponent } from './admin/admin-tabs/admin-tabs.component';
import { CategoryListComponent } from './admin/admin-tabs/category-list/category-list.component';
import { ExchangeListComponent } from './admin/admin-tabs/exchange-list/exchange-list.component';
import { StockInfoComponent } from './admin/admin-tabs/stock-info/stock-info.component';
import { UserListComponent } from './admin/admin-tabs/user-list/user-list.component';
import { UsersPortfolioComponent } from './admin/admin-tabs/users-portfolio/users-portfolio.component';
import { UserPortfolioComponent } from './portfolio/user-portfolio/user-portfolio.component';
import { LoginComponent } from './user/login/login.component';
import { SignupComponent } from './user/signup/signup.component';

const routes: Routes = [
  { path: "login", component: LoginComponent, pathMatch: "full" },
  { path: "signup", component: SignupComponent, pathMatch: "full" },
  { path: "portfolio/:userId/:userName", component: UserPortfolioComponent, pathMatch: "full"},
  {
    path: "admin-page/:userId", component: AdminTabsComponent,
    children: [
      { path: "user", component: UserListComponent, pathMatch: "full" },
      { path: "exchange", component: ExchangeListComponent, pathMatch: "full" },
      { path: "category", component: CategoryListComponent, pathMatch: "full" },
      { path: "stockinfo", component: StockInfoComponent, pathMatch: "full" },
      { path: "usersPortfolio", component: UsersPortfolioComponent, pathMatch: "full" }
    ]
  },
  { path: "", redirectTo: "login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
