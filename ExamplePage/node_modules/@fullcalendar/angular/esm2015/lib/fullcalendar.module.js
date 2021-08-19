import { NgModule } from '@angular/core';
import { globalPlugins } from '@fullcalendar/core';
import { FullCalendarComponent } from './fullcalendar.component';
export class FullCalendarModule {
    static registerPlugins(plugins) {
        globalPlugins.push(...plugins);
    }
}
FullCalendarModule.decorators = [
    { type: NgModule, args: [{
                declarations: [FullCalendarComponent],
                imports: [],
                exports: [FullCalendarComponent]
            },] }
];
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiZnVsbGNhbGVuZGFyLm1vZHVsZS5qcyIsInNvdXJjZVJvb3QiOiIiLCJzb3VyY2VzIjpbIi4uLy4uLy4uLy4uL3Byb2plY3RzL2Z1bGxjYWxlbmRhci9zcmMvbGliL2Z1bGxjYWxlbmRhci5tb2R1bGUudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsT0FBTyxFQUFFLFFBQVEsRUFBRSxNQUFNLGVBQWUsQ0FBQztBQUN6QyxPQUFPLEVBQUUsYUFBYSxFQUFhLE1BQU0sb0JBQW9CLENBQUM7QUFDOUQsT0FBTyxFQUFFLHFCQUFxQixFQUFFLE1BQU0sMEJBQTBCLENBQUM7QUFPakUsTUFBTSxPQUFPLGtCQUFrQjtJQUU3QixNQUFNLENBQUMsZUFBZSxDQUFDLE9BQW9CO1FBQ3pDLGFBQWEsQ0FBQyxJQUFJLENBQUMsR0FBRyxPQUFPLENBQUMsQ0FBQztJQUNqQyxDQUFDOzs7WUFURixRQUFRLFNBQUM7Z0JBQ1IsWUFBWSxFQUFFLENBQUMscUJBQXFCLENBQUM7Z0JBQ3JDLE9BQU8sRUFBRSxFQUFFO2dCQUNYLE9BQU8sRUFBRSxDQUFDLHFCQUFxQixDQUFDO2FBQ2pDIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgTmdNb2R1bGUgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7IGdsb2JhbFBsdWdpbnMsIFBsdWdpbkRlZiB9IGZyb20gJ0BmdWxsY2FsZW5kYXIvY29yZSc7XG5pbXBvcnQgeyBGdWxsQ2FsZW5kYXJDb21wb25lbnQgfSBmcm9tICcuL2Z1bGxjYWxlbmRhci5jb21wb25lbnQnO1xuXG5ATmdNb2R1bGUoe1xuICBkZWNsYXJhdGlvbnM6IFtGdWxsQ2FsZW5kYXJDb21wb25lbnRdLFxuICBpbXBvcnRzOiBbXSxcbiAgZXhwb3J0czogW0Z1bGxDYWxlbmRhckNvbXBvbmVudF1cbn0pXG5leHBvcnQgY2xhc3MgRnVsbENhbGVuZGFyTW9kdWxlIHtcblxuICBzdGF0aWMgcmVnaXN0ZXJQbHVnaW5zKHBsdWdpbnM6IFBsdWdpbkRlZltdKSB7XG4gICAgZ2xvYmFsUGx1Z2lucy5wdXNoKC4uLnBsdWdpbnMpO1xuICB9XG5cbn1cbiJdfQ==