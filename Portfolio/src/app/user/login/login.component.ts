import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public emailId: string = "";
  public userPassword: string = "";
  public isSent: boolean = false;


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private appService: UserService
  ) { }

  ngOnInit(): void {
  }

  signinFn() {
    if (!this.emailId) {
      alert("Please enter Email id");
    } else if (!this.userPassword) {
      alert("Please enter Password");
    } else {
      let data = {
        emailId: this.emailId,
        userPassword: this.userPassword
      };
      this.appService.signinFunction(data).subscribe(
        apiResponse => {
          if (apiResponse.is_admin == false) {
            console.log(apiResponse.userId)
            this.router.navigate(["/portfolio", apiResponse.userId, apiResponse.user_name]);
          }
          else
            this.router.navigate(["/admin-page", apiResponse.user_name]);
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
