import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args){

        JsonPath js = new JsonPath(Payload.coursePrice());
        //to print no.of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println(count);
        //to print purchase amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        //print title of first course
        String titleFirstCourse = js.get("courses[0].title");
        System.out.println(titleFirstCourse);
        //print price of second course
        int priceOfSecondCourse= js.getInt("courses[2].price");
        System.out.println(priceOfSecondCourse);
        //print all courses and their respective titles
        for(int i=0; i<count; i++){
            String courseTitles = js.get("courses["+i+"].title");
            System.out.println(courseTitles);
            int coursePrice = js.getInt("courses["+i+"].price");
            System.out.println(coursePrice);
        }

        System.out.println("Print no.of copies sold by RPA Course");
        for(int i=0; i<count; i++){
            String courseTitles = js.get("courses["+i+"].title");
            if(courseTitles.equalsIgnoreCase("RPA"))
            {
                int copies = js.get("courses["+i+"].copies");
                System.out.println(copies);
                break;
            }
        }

    }
}
