/**
 * Created by domin_000 on 17.05.2016.
 */
///<reference path="model.ts"/>

const register = (() => {
    return () => {
        const username = $("#username").val();
        const password = $("#password").val();
        const confirm = $("#confirm-password").val();

        if (password === confirm) {
            console.log("jestem");
            $.ajax({
                type: "Post",
                url: "api/auth/register",
                data: JSON.stringify({username: username, password: password, confirmPassword: confirm}),
                success: (response:Model.HttpData<Model.Post[]>) => {
                    console.log(response);
                    if (response.status == 200 && response.data.success && response.data.value) {
                        location.href = "/";
                    }
                },
                error: (error) => {
                    console.log("jestem3");
                    console.log(error);
                    alert(error.responseJSON.message);
                }
            })
        }
    };
})();
