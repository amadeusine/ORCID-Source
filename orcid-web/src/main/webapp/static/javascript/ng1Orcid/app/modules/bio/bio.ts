import * as angular from "angular";
import { NgModule } from "@angular/core";
import { downgradeComponent, UpgradeModule } from "@angular/upgrade/static";
import { CommonNg2Module } from "./../common/common";
import { bioComponent } from "./bio.component";


// This is the Angular 1 part of the module
export const bioModule = angular.module("bioModule", []);

// This is the Angular 2 part of the module
@NgModule({
  imports: [CommonNg2Module],
  declarations: [bioComponent],
  entryComponents: [bioComponent],
  providers: []
})
export class bioNg2Module {}

// components migrated to angular 2 should be downgraded here
//Must convert as much as possible of our code to directives
bioModule
  .directive("bioNg2", <any>downgradeComponent({
    component: bioComponent
  }))
