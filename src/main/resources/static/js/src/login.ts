/**
 * Created by domin_000 on 17.05.2016.
 */
const register = (() => {
    let register = () => {
        const username = $("#username").val();
        const password = $("#password").val();
        const confirm = $("#confirm-password").val();

        if(password === confirm){
            $.ajax({
                type : "POST",
                url : "api/auth/register",
                data : JSON.stringify({username : username, password : password, confirmPassword : confirm}),
                success: (response) => {

                },
                error: (error) => {
                    console.log(error);
                    alert(error.responseJSON.message);
                }
            })
        }
    };
    return register;
})();
