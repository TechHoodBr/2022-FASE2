import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Category } from './category.model';
import { environment } from '../../../environments/environment';

@Injectable()
export class CategoryService {

    constructor(private httpClient: HttpClient) { }

    getAll() {
        return this.httpClient.get<Category[]>(`${environment.api}/categoria`);
    }

    getById(id: any) {
        return this.httpClient.get<Category>(`${environment.api}/categoria/${id}`);
    }

    deleteById(id: any) {
        return this.httpClient.delete<Category>(`${environment.api}/categoria/${id}`);
    }

    post(data: Category) {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return this.httpClient.post<Category>(`${environment.api}/categoria`, data, { headers: headers });
    }

    put(data: Category) {
        return this.httpClient.put<Category>(`${environment.api}/categoria/${data.id}`, data);
    }
}