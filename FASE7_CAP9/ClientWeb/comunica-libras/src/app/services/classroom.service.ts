import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Aula } from '../model/Aula';

@Injectable({
  providedIn: 'root',
})
export class ClassroomService {
  private _data: BehaviorSubject<any> = new BehaviorSubject(null);

  /**
   * Constructor
   */
  constructor(private _httpClient: HttpClient) {}

  search(data: Aula): Observable<Aula[]> {
    return this._httpClient
      .post<Aula[]>(environment.ws + '/aula/buscar', data || {})
      .pipe(
        tap((response: Aula[]) => {
          this._data.next(response);
        })
      );
  }
}
