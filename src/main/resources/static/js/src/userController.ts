///<reference path="tsd.d.ts"/>
///<reference path="userService.ts"/>

module Controllers{
    export class UserController{
        public users: Model.User[];
        public loggedUser:Model.User;

        constructor(private scope:ng.IScope, private userService:Services.IUserService, userMode : Model.UserMode){
            this.getLoggedUser();
            this.resolve(userMode);
        }

        private resolve(userMode : Model.UserMode){
            switch (userMode){
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

        getAllUsers(){
            this.userService.getAllUsers((res) => {
                console.log(res);
                if(res.status === 200 && res.data.success){
                    this.users = res.data.value;
                }
            });
        }

        public getLoggedUser(){
            this.userService.getLoggedUser((res) => {
                if(res.status == 200 && res.data.success) {
                    this.loggedUser = res.data.value;
                }
            });
        }
    }
}