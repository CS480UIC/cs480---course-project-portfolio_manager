import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { SigninComponent } from "./signin/signin.component";
import { SignupComponent } from './signup/signup.component';
import { UserPortfolioComponent } from './user-portfolio/user-portfolio.component';

const routes: Routes = [
  { path: "login", component: SigninComponent, pathMatch: "full" },
  { path: "signup", component: SignupComponent, pathMatch: "full"},
  { path: "portfolio/:userId/:userName", component: UserPortfolioComponent, pathMatch: "full"},
  { path: "admin-page/:userId", component: AdminPageComponent, pathMatch: "full"},
  { path: "", redirectTo: "login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
