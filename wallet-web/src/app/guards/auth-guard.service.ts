import {CanActivate, Router} from "@angular/router";
import {LottoLocalStorageService} from "../../../../../Workspace/vexios/bidlotto-web/src/app/shared/lotto-localstorage.service";
import {Injectable} from "@angular/core";
import {MyLocalStorageService} from "../auth/my-local-storage.service";
/**
 * Created by DAVIDE-SE on 23/02/2017.
 *
 * This service acts as a Guardian to be sure the current user is logged in.
 * If he is not, the system redirects him to the sign-in page.
 *
 */
@Injectable()
export class  AuthGuardService implements CanActivate {

  constructor(private _router: Router, private _store: MyLocalStorageService) {

  }

  canActivate(): boolean {
    if (this._store._getCurrentUser() !== null) {
      return true;
    }

    this._router.navigate(['/login']);
    return false;
  }
}
