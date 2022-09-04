
export const  IsAuth = () => {
    let token = localStorage.getItem("AccessToken")
    return token != null && token != undefined;
}
