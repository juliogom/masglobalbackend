import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';

import { SERVER_API_URL } from './app.constants';
import { Employee } from './employee.model';
//import { createRequestOption } from '../../../shared/model/request-util';

@Injectable()
export class EmployeeService {
    private resourceUrl = SERVER_API_URL + 'api/employees';

    constructor(private http: HttpClient) { }
    
    find(id: number) {
        return this.http.get<Employee>(`${this.resourceUrl}/${id}`);
    }

    query(){
        var request=this.http.get<Employee[]>(this.resourceUrl);
        return request;
    }
   
}
