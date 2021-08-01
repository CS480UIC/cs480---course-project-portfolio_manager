import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'
import { CommonModule } from '@angular/common';
import { UserPortfolioComponent } from './user-portfolio/user-portfolio.component';



@NgModule({
  declarations: [
    UserPortfolioComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
  ]
})
export class PortfolioModule { }
