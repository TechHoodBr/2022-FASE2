import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/model/Usuario';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private _data: BehaviorSubject<any> = new BehaviorSubject(null);

  /**
   * Constructor
   */
  constructor(private _httpClient: HttpClient) {}

  login(data: Usuario): Observable<Usuario> {
    return this._httpClient.post<Usuario>(environment.ws + '/login', data).pipe(
      tap((response: Usuario) => {
        this._data.next(response);
      })
    );
  }

  post(data: Usuario): Observable<Usuario> {
    return this._httpClient
      .post<Usuario>(environment.ws + '/usuario', data)
      .pipe(
        tap((response: Usuario) => {
          this._data.next(response);
        })
      );
  }
}
