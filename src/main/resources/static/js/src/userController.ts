///<reference path="tsd.d.ts"/>
///<reference path="userService.ts"/>

module Controllers {
    import User = Model.User;
    export class UserController {
        public users:Model.User[];
        public loggedUser:Model.User;

        constructor(private scope:ng.IScope, private $q:angular.IQService,private $cookies: angular.cookies.ICookiesService, private userService:Services.IUserService, userMode:Model.UserMode) {
            this.getLoggedUser().then((res : Model.User) => {
                if(res.role == "ADMIN" || userMode == Model.UserMode.None){
                    this.resolve(userMode);
                }else{
                    alert("Nie masz uprawnień do przeglądania tej strony")
                }
            }).catch((error) => {
                alert("Nie masz uprawnień do przeglądania tej strony")
            });

        }

        private resolve(userMode:Model.UserMode) {
            switch (userMode) {
                case Model.UserMode.AllUsers:
                    this.getAllUsers();
                    break;
                case Model.UserMode.UserById:
                    this.getAllUsers();
                    break;
                case Model.UserMode.None:
                    break;
            }
        }

        public getAllUsers() {
            this.userService.getAllUsers((res) => {
                if (res.status === 200 && res.data.success) {
                    this.users = res.data.value;
                }
            });
        }
        
        public logout(){
            location.href = "/logout";
        }

        public getLoggedUser() {
            const deferred = this.$q.defer();

            this.userService.getLoggedUser((res) => {
                if (res.status == 200 && res.data.success) {
                    this.loggedUser = res.data.value;
                    deferred.resolve(this.loggedUser);
                }
                else {
                    deferred.reject({isSuccess : false, message: "Unauthorized access"});
                }
            });
            return deferred.promise;
        }
    }
}