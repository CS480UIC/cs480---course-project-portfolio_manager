import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AppServiceService } from '../app-service.service';
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  public userName: string = "";
  public userPassword: string = "";
  public isSent: boolean = false;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private appService: AppServiceService
  ) { }

  ngOnInit(): void {
  }

  signinFn() {
    if (!this.userName) {
      alert("Please enter Email id");
    } else if (!this.userPassword) {
      alert("Please enter Password");
    } else {
      let data = {
        emailId: this.userName,
        userPassword: this.userPassword
      };
      this.appService.signinFunction(data).subscribe(
        apiResponse => {
          if (apiResponse.is_admin == false)
            this.router.navigate(["/portfolio"]);
          else
            this.router.navigate(["/admin-page"]);
        },
        err => {
          console.log(err);
          alert("invalid Username or Password");
        }
      );
    }
  }

  goToSignUp() {
    this.router.navigate(["/signup"]);
  }

}
