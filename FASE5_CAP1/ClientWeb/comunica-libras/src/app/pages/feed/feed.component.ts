import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { Aula } from 'src/app/model/Aula';
import { ClassroomService } from 'src/app/services/classroom.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css'],
})
export class FeedComponent implements OnInit, OnDestroy {
  classrooms: Aula[];
  private _unsubscribeAll: Subject<any> = new Subject<any>();

  constructor(
    private _classroomService: ClassroomService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this._classroomService
      .search(null)
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe((data) => {
        this.classrooms = data;
      });
  }

  redirecionar(classsroom: Aula) {
    if (classsroom.video !== null)
      this._router.navigate(['classroom', classsroom.id]);
  }

  ngOnDestroy(): void {
    this._unsubscribeAll.next(null);
    this._unsubscribeAll.complete();
  }
}
