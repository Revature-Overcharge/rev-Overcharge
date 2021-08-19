import { ElementRef, AfterViewInit, DoCheck, AfterContentChecked, OnDestroy } from '@angular/core';
import { Calendar, CalendarOptions } from '@fullcalendar/core';
import * as ɵngcc0 from '@angular/core';
export declare class FullCalendarComponent implements AfterViewInit, DoCheck, AfterContentChecked, OnDestroy {
    private element;
    options?: CalendarOptions;
    deepChangeDetection?: boolean;
    private calendar;
    private optionSnapshot;
    constructor(element: ElementRef);
    ngAfterViewInit(): void;
    ngDoCheck(): void;
    ngAfterContentChecked(): void;
    ngOnDestroy(): void;
    getApi(): Calendar;
    static ɵfac: ɵngcc0.ɵɵFactoryDeclaration<FullCalendarComponent, never>;
    static ɵcmp: ɵngcc0.ɵɵComponentDeclaration<FullCalendarComponent, "full-calendar", never, { "options": "options"; "deepChangeDetection": "deepChangeDetection"; }, {}, never, never>;
}

//# sourceMappingURL=fullcalendar.component.d.ts.map