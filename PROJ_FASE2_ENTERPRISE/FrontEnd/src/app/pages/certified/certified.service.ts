import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Certified } from './certified.model';
import { environment } from '../../../environments/environment';

@Injectable()
export class CertifiedService {

    constructor(private httpClient: HttpClient) { }

    getAll() {
        return this.httpClient.get<Certified[]>(`${environment.api}/certificado`);
    }

    getById(id: any) {
        return this.httpClient.get<Certified>(`${environment.api}/certificado/${id}`);
    }

    deleteById(id: any) {
        return this.httpClient.delete<Certified>(`${environment.api}/certificado/${id}`);
    }

    post(data: Certified) {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return this.httpClient.post<Certified>(`${environment.api}/certificado`, data, { headers: headers });
    }

    put(data: Certified) {
        return this.httpClient.put<Certified>(`${environment.api}/certificado/${data.id}`, data);
    }
}