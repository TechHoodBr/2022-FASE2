import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { Aula } from 'src/app/model/Aula';
import { ClassroomService } from 'src/app/services/classroom.service';

@Component({
  selector: 'app-classroom',
  templateUrl: './classroom.component.html',
  styleUrls: ['./classroom.component.css'],
})
export class ClassroomComponent implements OnInit, OnDestroy {
  classroom: Aula = new Aula();
  private _unsubscribeAll: Subject<any> = new Subject<any>();

  constructor(
    private _activedRoute: ActivatedRoute,
    private _classroomService: ClassroomService
  ) {}

  ngOnInit(): void {
    let aula = new Aula();
    aula.id = this._activedRoute.snapshot.params['id'];

    this._classroomService
      .search(aula)
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe((data) => {
        this.classroom = data[0];
        this.classroom.descricao = this.classroom.descricao.replaceAll(
          '\\n',
          '<br/>'
        );
      });
  }

  ngOnDestroy() {
    this._unsubscribeAll.next(null);
    this._unsubscribeAll.complete();
  }
}
