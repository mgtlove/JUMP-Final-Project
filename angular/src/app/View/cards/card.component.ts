import {Component, Input, OnInit} from '@angular/core';
import { Location } from '../../models/location.model';
import { Student } from '../../models/student.model';
import { Instructor } from '../../models/instructor.model';
import { Resource } from '../../models/resource.model';
import { Tool } from '../../models/tool.model';
import { Repository } from '../../models/repository';

@Component({
    selector: 'app-card',
    templateUrl: './card.component.html',
    styleUrls: ['./card.component.css']
})

export class CardComponent {
  @Input() location: Location;
  @Input() student: Student;
  @Input() instructor: Instructor;
  @Input() resource: Resource;
  @Input() tool: Tool;

  constructor(private repo: Repository) {}
}
