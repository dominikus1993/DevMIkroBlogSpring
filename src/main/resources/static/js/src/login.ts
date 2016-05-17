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
                headers: {"Content-Type": "application/json"},
                url: "api/auth/register",
                data: JSON.stringify({username: username, password: password, confirmPassword: confirm}),
                success: (response:Model.Result<boolean>) => {
                    console.log(response);
                    if (response.success && response.value) {
                        location.href = "/";
                    }
                    else{
                        alert("Nie udało się zarejestrować użytkownika")
                    }
                },
                error: (error) => {
                    console.log(error);
                    alert(error.responseJSON.message);
                }
            })
        }
        else{
            alert("Hasła nie są takie same")
        }
    };
})();
