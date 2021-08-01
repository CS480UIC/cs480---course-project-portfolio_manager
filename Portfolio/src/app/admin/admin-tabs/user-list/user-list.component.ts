import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { UserService } from 'src/app/user/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  public userId: string = "";
  public userData: any;

  userHeaders = ["userId", "user_name", "email_id", "contact"];
  userHeadings = ["User Id", "User Name", "Email Id", "Contact"];

  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: UserService
  ) { }

  ngOnInit(): void {
    // get all user data
    this.appService.getAllUsers().subscribe(
      apiResponse => {
        this.userData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  }

  deleteUser() {
    this.appService.deleteUserById(this.userId).subscribe(
      apiResponse => {
        alert("User Deleted")
      },
      err => {
        if (err.status === 200) {
          alert("User Deleted Successfully")
          window.location.reload();
        } else if (err.status === 500) {
          alert("User Not found");
          window.location.reload();
        } else {
          alert("Some error occured");
        }
      }
    );
  }

}
