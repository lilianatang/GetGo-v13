<?php


require_once '..\php_scripts\include\DB_Functions.php';
$db = new DB_Functions();

// json response array
$response = array("error" => FALSE);

if (isset($_POST['first_name']) && isset($_POST['email']) && isset($_POST['password']) && isset($_POST['last_name']) && isset($_POST['city']) && isset($_POST['province']) && isset($_POST['postal_code'])) {

    // receiving the post params
    $first_name = $_POST['first_name'];
    $last_name = $_POST['last_name'];
    $city = $_POST['city'];
    $province = $_POST['province'];
    $postal_code = $_POST['postal_code'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    // check if user is already existed with the same email
    if ($db->isUserExisted($email)) {
        // user already existed
        $response["error"] = TRUE;
        $response["error_msg"] = "User already existed with " . $email;
        echo json_encode($response);
    } else {
        // create a new user
        $user = $db->storeUser($first_name, $last_name, $city, $province, $postal_code, $email, $password);
        if ($user) {
            // user stored successfully
            $response["error"] = FALSE;
            $response["uid"] = $user["student_id"];
            $response["user"]["first_name"] = $user["first_name"];
            $response["user"]["last_name"] = $user["last_name"];
            $response["user"]["city"] = $user["city"];
            $response["user"]["province"] = $user["province"];
            $response["user"]["postal_code"] = $user["postal_code"];
            $response["user"]["email"] = $user["email"];
            $response["user"]["created_at"] = $user["created_at"];
            $response["user"]["updated_at"] = $user["updated_at"];
            echo json_encode($response);
        } else {
            // user failed to store
            $response["error"] = TRUE;
            $response["error_msg"] = "Unknown error occurred in registration!";
            echo json_encode($response);
        }
    }
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (first name, last_name, city, province, postal_code, email or password) is missing!";
    echo json_encode($response);
}
?>

