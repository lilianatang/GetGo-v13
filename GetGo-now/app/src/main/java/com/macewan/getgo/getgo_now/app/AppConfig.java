package com.macewan.getgo.getgo_now.app;

public class AppConfig {
	// Server user login url

	public static String localhost  = "siham.ca";

	public static String URL_LOGIN = "http://"+ localhost + "/android_login_api/login.php";

	// Server user register url
	public static String URL_REGISTER = "http://"+ localhost +  "/android_login_api/register.php";

	// Department url
	public static String URL_DEPARTMENT = "http://"+ localhost  + "/android_login_api/db_department.php";

	// Conditions url
	public static String URL_CONDITION = "http://"+ localhost + "/android_login_api/get_conditions.php";

	// Condition Links url
	public static String URL_CONDITION_LINK = "http://"+ localhost + "/android_login_api/get_condition_links.php";

	//Groups url
	public static String URL_GROUP = "http://"+ localhost + "/android_login_api/get_groups.php";

	//Courses url
	public static String URL_COURSE = "http://"+ localhost + "/android_login_api/get_all_courses.php";

	//Courses url
	public static String URL_INSTITUTION = "http://"+ localhost +"/android_login_api/get_institutions.php";

}
