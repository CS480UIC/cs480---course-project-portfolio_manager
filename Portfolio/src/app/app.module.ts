import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {MatTabsModule} from '@angular/material/tabs';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './user/login/login.component';
import { SignupComponent } from './user/signup/signup.component';
import { AdminTabsComponent } from './admin/admin-tabs/admin-tabs.component';
import { UserListComponent } from './admin/admin-tabs/user-list/user-list.component';
import { CategoryListComponent } from './admin/admin-tabs/category-list/category-list.component';
import { ExchangeListComponent } from './admin/admin-tabs/exchange-list/exchange-list.component';
import { StockInfoComponent } from './admin/admin-tabs/stock-info/stock-info.component';
import {MatSelectModule} from '@angular/material/select';
import { UserPortfolioComponent } from './portfolio/user-portfolio/user-portfolio.component';
import { UsersPortfolioComponent } from './admin/admin-tabs/users-portfolio/users-portfolio.component';
import {MatDatepickerModule} from '@angular/material/datepicker';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminTabsComponent,
    UserListComponent,
    CategoryListComponent,
    ExchangeListComponent,
    StockInfoComponent,
    UserPortfolioComponent,
    UsersPortfolioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatSelectModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
