import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AppServiceService } from '../app-service.service';

@Component({
  selector: 'app-user-portfolio',
  templateUrl: './user-portfolio.component.html',
  styleUrls: ['./user-portfolio.component.css']
})
export class UserPortfolioComponent implements OnInit {
  public userData: any;
  public contact: string = "";


  constructor(
    private _router: Router,
    private route: ActivatedRoute,
    private appService: AppServiceService
  ) { }

  ngOnInit() { 
    this.route.params.subscribe(params => {
      this.userData = params;
    });
    console.log(this.userData)
  };

  updateContact() { 
    this.appService.updateUserContact(this.userData.userId, this.contact).subscribe(
      apiResponse => {
        console.log(apiResponse);
        alert("User updated")
      },
      err => {
        if(err.status === 200){
          alert("User Contact updated Successfully")
          window.location.reload();
        }else{
          alert("Some error occured");
        }
      }
    );
  };

}
