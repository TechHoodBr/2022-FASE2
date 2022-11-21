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
  scope = { filter: { item: 1, classroomsTemp: null } };
  classrooms: Aula[];
  private _classroomsFilter: Aula[];
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

  ngOnDestroy(): void {
    this._unsubscribeAll.next(null);
    this._unsubscribeAll.complete();
  }

  redirecionar(classsroom: Aula) {
    if (classsroom.video !== null)
      this._router.navigate(['classroom', classsroom.id]);
  }

  navItem(item) {
    this.scope.filter.item = item;

    if (item >= 2) {
      this.scope.filter.classroomsTemp = this.classrooms;
      this.classrooms.filter((item) => item.video !== null);
    } else {
      this.classrooms = this.scope.filter.classroomsTemp;
    }
  }
}
