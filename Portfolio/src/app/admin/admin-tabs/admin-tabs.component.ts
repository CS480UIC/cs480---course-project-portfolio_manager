import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-admin-tabs',
  templateUrl: './admin-tabs.component.html',
  styleUrls: ['./admin-tabs.component.css']
})
export class AdminTabsComponent implements OnInit {
  public adminName: any;
  navLinks: any[];
  activeLinkIndex = 0;

  constructor(
    private _router: Router,
    private route: ActivatedRoute
  ) {
    this.navLinks = [
      {
        label: 'User',
        link: './user',
        index: 0
      }, {
        label: 'Exchange',
        link: './exchange',
        index: 1
      }, {
        label: 'Stock Category',
        link: './category',
        index: 2
      },
      {
        label: 'Stock Info',
        link: './stockinfo',
        index: 2
      },
      {
        label: 'All User Portfolio',
        link: './usersPortfolio',
        index: 2
      }
    ];
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.adminName = params;
    });
  }

 

}
