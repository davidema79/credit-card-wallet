import {EventEmitter, Injectable} from '@angular/core';
import {UserDetails} from "./user.model";
import {isNullOrUndefined} from "util";

@Injectable()
export class MyLocalStorageService {

  private static CURRENT_USER = 'currentUser';

  constructor() { }

  public saveCurrentUser(user: UserDetails) {
    localStorage.setItem(MyLocalStorageService.CURRENT_USER, JSON.stringify(user));
  }

  public getCurrentUser() {
    const savedValue = localStorage.getItem(MyLocalStorageService.CURRENT_USER);
    if (isNullOrUndefined(savedValue)) {
      return null;
    }

    return JSON.parse(savedValue) as UserDetails;
  }

  public removeCurrentUser() {
    localStorage.removeItem(MyLocalStorageService.CURRENT_USER);
  }

}
