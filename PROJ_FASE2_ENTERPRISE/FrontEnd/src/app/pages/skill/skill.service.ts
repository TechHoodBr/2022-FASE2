import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Skill } from './skill.model';
import { environment } from '../../../environments/environment';

@Injectable()
export class SkillService {

    constructor(private httpClient: HttpClient) { }

    getAll() {
        return this.httpClient.get<Skill[]>(`${environment.api}/skill`);
    }

    getById(id: any) {
        return this.httpClient.get<Skill>(`${environment.api}/skill/${id}`);
    }

    deleteById(id: any) {
        return this.httpClient.delete<Skill>(`${environment.api}/skill/${id}`);
    }

    post(data: Skill) {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return this.httpClient.post<Skill>(`${environment.api}/skill`, data, { headers: headers });
    }

    put(data: Skill) {
        return this.httpClient.put<Skill>(`${environment.api}/skill/${data.id}`, data);
    }
}