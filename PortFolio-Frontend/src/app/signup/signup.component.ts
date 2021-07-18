import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AppServiceService } from '../app-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  title = 'PortFolio-Frontend';
  public userName: string = "";
  public emailId: string = "";
  public phoneNumber: string = "";
  public userPassword: string = "";

  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AppServiceService
  ) { }

  ngOnInit() { };

  goToSignIn() {
    this._router.navigate(["/"]);
  }
  onSignUp() {
    if (!this.userName) {
      alert("enter User Name");
    } else if (!this.emailId) {
      alert("enter mobile");
    } else if (!this.phoneNumber) {
      alert("Invalid email");
    } else if (!this.userPassword) {
      alert("enter password");
    } else {
      this.appService.signupFunction(this.userName, this.emailId, this.phoneNumber, this.userPassword).subscribe(
        apiResponse => {
          console.log(apiResponse);
        },
        err => {
          console.log(err);
            if(err.status === 200){
              alert("User Created Successfully")
              this._router.navigate(["/"]);
            }else{
              alert("Some error occured");
            }    
        }
      );
    }
  }
}
