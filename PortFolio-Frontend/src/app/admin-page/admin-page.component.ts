import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AppServiceService } from '../app-service.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {
  public adminName: any;
  public userId: string = "";
  public userData: any;
  public adminData: any;
  headers = ["user_id", "user_name", "email_id", "contact"];
  headings = ["User Id", "User Name", "Email Id", "Contact"];


  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AppServiceService
  ) { }

  ngOnInit() { 
    this.route.params.subscribe(params => {
      this.adminName = params;
    });
    console.log(this.adminName.userId)
    // get all user data
    this.appService.getAllUsers().subscribe(
      apiResponse => {
        console.log(apiResponse);
        this.userData = apiResponse;
      },
      err => {
        alert("some error occured");
      }
    );
  };
  deleteUser(){
    this.appService.deleteUserById(this.userId).subscribe(
      apiResponse => {
        console.log(apiResponse);
        alert("User Deleted")
      },
      err => {
        if(err.status === 200){
          alert("User Deleted Successfully")
          window.location.reload();
        }else if(err.status === 500){
          alert("User Not found");
          window.location.reload();
        }else{
          alert("Some error occured");
        }
      }
    );
  }

}
