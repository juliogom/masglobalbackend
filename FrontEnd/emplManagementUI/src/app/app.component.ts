import { Component, OnInit } from '@angular/core';

import { Employee } from './employee.model';

import {EmployeeService} from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'employee management';

  employees: Employee[];
  searchId: number;

  constructor(private employeeService:EmployeeService) { }

  ngOnInit() {
  }

  find(){

    if(!this.searchId){

      this.loadAll();

    }else{
      this.employees=[];
      this.findOne(this.searchId);
    }
   
  }

  findOne(id){
    this.employeeService.find(id)
    .subscribe( data => {
      console.log(data);
      if(data){
        this.employees.push(data);
      }else{
        alert("No Employees with that Id");
      }
      
    });
  }


  loadAll() {

    this.employeeService.query()
    .subscribe( data => {
      console.log(data);
      this.employees=data;
    });
  }

}
