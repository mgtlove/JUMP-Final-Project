import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';

// import { AppRoutingModule } from './app-routing.module';
// import { InstructorModule } from './View/InstructorLoggedIn/instructor.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import {UserLoginComponent} from './View/userLogin.component';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import { LogoutComponent } from './logout/logout.component';
import { CheckComponent } from './check/check.component';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {User} from './models/user.model';
import {Student} from './models/student.model';
import { InstructorHomeComponent } from './View/InstructorLoggedIn/instructorHome.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/instructor', pathMatch: 'full' },
  { path: 'instructor', component: InstructorHomeComponent},
  { path: 'student', component: Student },
  { path: 'login', component: UserLoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'check', component: CheckComponent }
];

@NgModule({
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  declarations: [
    AppComponent,
    NavbarComponent,
    UserLoginComponent,
    LogoutComponent,
    CheckComponent,
    InstructorHomeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
