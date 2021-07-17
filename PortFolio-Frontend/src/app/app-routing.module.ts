import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from "./signin/signin.component";
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: "login", component: SigninComponent, pathMatch: "full" },
  { path: "signup", component: SignupComponent, pathMatch: "full"},
  { path: "", redirectTo: "login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
