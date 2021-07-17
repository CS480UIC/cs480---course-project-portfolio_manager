import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  public emailId: string = "";
  public userPassword: string = "";
  public isSent: boolean = false;
  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  signinFn() { }
  goToSignUp() {
    this.router.navigate(["/signup"]);
  }

}
