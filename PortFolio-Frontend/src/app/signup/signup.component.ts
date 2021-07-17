import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  title = 'PortFolio-Frontend';
  public cntryName: any;
  public country = [];
  public cntryCode: any;
  public code = [];
  public selectedCountryCode: string = "";
  public firstName: string = "";
  public lastName: string = "";
  public emailId: string= "";
  public phoneNumber: string = "";
  public userPassword: string = "";
  
  constructor(
    private _router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(){};

  goToSignIn() {
    this._router.navigate(["/"]);
  }
  onSignUp() {}

}
