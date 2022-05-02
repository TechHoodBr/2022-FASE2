/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { Component, OnInit } from '@angular/core';
import { AnalyticsService } from './@core/utils/analytics.service';
import { SeoService } from './@core/utils/seo.service';
import { LoadingService } from './@core/utils/loading/loading.service';

@Component({
  selector: 'ngx-app',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent implements OnInit {

  loading: boolean;

  constructor(
    private analytics: AnalyticsService,
    private seoService: SeoService,
    private loaderService: LoadingService) {
    this.loaderService.isLoading.subscribe((loading) => {
      this.loading = loading;
    });
  }

  ngOnInit(): void {
    this.analytics.trackPageViews();
    this.seoService.trackCanonicalChanges();
  }
}
