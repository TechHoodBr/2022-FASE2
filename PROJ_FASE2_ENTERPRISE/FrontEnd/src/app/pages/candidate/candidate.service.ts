import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Candidate } from './candidate.model';
import { environment } from '../../../environments/environment';
import { Skills } from '../skill/skill.model';
import { CertifiedService } from '../certified/certified.service';
import { Certifieds } from '../certified/certified.model';

@Injectable()
export class CandidateService {

    constructor(private httpClient: HttpClient) { }

    getAll() {
        return this.httpClient.get<Candidate[]>(`${environment.api}/candidato`);
    }

    getById(id: any) {
        return this.httpClient.get<Candidate>(`${environment.api}/candidato/${id}`);
    }

    deleteById(id: any) {
        return this.httpClient.delete<Candidate>(`${environment.api}/candidato/${id}`);
    }

    post(data: Candidate) {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return this.httpClient.post<Candidate>(`${environment.api}/candidato/criar`, data, { headers: headers });
    }

    put(data: Candidate) {
        return this.httpClient.put<Candidate>(`${environment.api}/candidato/${data.id}`, data);
    }

    getSearch(search: Candidate) {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return this.httpClient.post<Candidate[]>(`${environment.api}/candidato/buscar`, search, { headers: headers });
    }

    postSkill(id: Number, skills: Skills[]) {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return this.httpClient.post<Candidate>(`${environment.api}/candidato/${id}/skill`, skills, { headers: headers });
    }

    postCertificado(id: Number, certificados: Certifieds[]) {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return this.httpClient.post<Candidate>(`${environment.api}/candidato/${id}/certificado`, certificados, { headers: headers });
    }
}